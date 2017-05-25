/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 */
package hangman;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

interface HiddenWord {
    boolean wrongGuess();
    boolean guessed();
    HiddenWord tryCharacter(char c);
    void informPlayer(HangmanPlayer p);

    class Init implements HiddenWord {
        private final String secret;

        public Init(String secret) {
            this.secret = secret;
        }

        @Override
        public boolean wrongGuess() {
            return false;
        }

        @Override
        public boolean guessed() {
            return false;
        }

        @Override
        public HiddenWord tryCharacter(char c) {
            boolean visible[] = new boolean[secret.length()];
            boolean hit = false;
            for (int i = 0; i < secret.length(); ++i) {
                if (secret.charAt(i) == c && !visible[i]) {
                    visible[i] = true;
                    hit = true;
                }
            }
            return new AfterAttempt(secret, visible, !hit);
        }

        @Override
        public void informPlayer(HangmanPlayer p) {
            p.inform("The word: ");
            p.inform(secret.replaceAll(".", "?"));
            p.inform("\n\n");
        }
    }

    class AfterAttempt implements HiddenWord {
        private final String secret;
        private final boolean[] visible;
        private final boolean wrongGuess;

        public AfterAttempt(String secret, boolean[] visible, boolean falseTry) {
            this.secret = secret;
            this.visible = visible;
            this.wrongGuess = falseTry;
        }

        @Override
        public boolean wrongGuess() {
            return wrongGuess;
        }

        @Override
        public boolean guessed() {
            boolean done = true;
            for (int i = 0; i < secret.length(); ++i) {
                if (!visible[i]) {
                    done = false;
                }
            }
            return done;
        }

        @Override
        public HiddenWord tryCharacter(char c) {
            boolean visible[] = Arrays.copyOf(this.visible, this.visible.length);
            boolean hit = false;
            for (int i = 0; i < secret.length(); ++i) {
                if (secret.charAt(i) == c && !visible[i]) {
                    visible[i] = true;
                    hit = true;
                }
            }
            return new AfterAttempt(secret, visible, !hit);
        }

        @Override
        public void informPlayer(HangmanPlayer p) {
            p.inform("The word: ");
            for (int i = 0; i < secret.length(); ++i) {
                if (visible[i]) {
                    p.inform(secret.charAt(i));
                } else {
                    p.inform("?");
                }
            }
            p.inform("\n\n");
        }
    }
}

/**
 * A player of hangman game
 * 
 * @author skapral
 */
interface HangmanPlayer {
    /**
     * Inform a player of how the game flows
     * 
     * @param str 
     */
    void inform(Object str);
    
    /**
     * Ask player to guess a character
     * 
     * @return
     * @throws Exception if player can't guess a letter for some reason
     */
    char guessedCharacter() throws Exception;

    class Console implements HangmanPlayer {

        private final PrintStream output;
        private final Scanner scanner;

        public Console(InputStream is, OutputStream os) {
            this(new PrintStream(os), new Scanner(is));
        }

        public Console(PrintStream output, Scanner scanner) {
            this.output = output;
            this.scanner = scanner;
        }

        @Override
        public char guessedCharacter() throws Exception {
            return scanner.next().charAt(0);
        }

        @Override
        public void inform(Object str) {
            output.print(str);
        }
    }
}

/**
 * A list of words for Hangman game
 * 
 * @author skapral
 */
interface HangmanVocabulary {
    /**
     * Pick a random word from the vocabulary
     * 
     * @return 
     */
    HiddenWord randomWord();

    class FromArray implements HangmanVocabulary {
        private final String[] words;

        public FromArray(String[] words) {
            this.words = words;
        }

        @Override
        public HiddenWord randomWord() {
            return new HiddenWord.Init(
                    words[new Random().nextInt(words.length)]
            );
        }
    }
}
/**
 * A turn-based game with one player
 * 
 * @author skapral
 */
interface Game {
    /**
     * Plays one game session with the player till the end
     * 
     * @param player
     * @throws Exception then someone is cheating
     */
    void playSessionWith(HangmanPlayer player) throws Exception;

    class Hangman implements Game {
        private final HangmanVocabulary vocabulary;
        private final int maxMistakes;

        public Hangman(HangmanVocabulary vocabulary, int maxMistakes) {
            this.vocabulary = vocabulary;
            this.maxMistakes = maxMistakes;
        }

        @Override
        public void playSessionWith(HangmanPlayer player) throws Exception {
            GameSession gs = new GameSession.Starting(player, vocabulary, maxMistakes);
            while (!gs.isOver()) {
                gs = gs.newTurn().gameSessionAfterTurn();
            }
        }
    }
}

/**
 * A player turn in turn-based game session
 * 
 * @author skapral
 */
interface PlayerTurn {
    /**
     * Calculates game session state after the turn is made by player
     * 
     * @return
     * @throws Exception 
     */
    GameSession gameSessionAfterTurn() throws Exception;
    
    class TryLetter implements PlayerTurn {
        private final HangmanPlayer player;
        private final HiddenWord secretWord;
        private final int madeMistakes;
        private final int maxMistakes;

        public TryLetter(HangmanPlayer player, HiddenWord secretWord, int madeMistakes, int maxMistakes) {
            this.player = player;
            this.secretWord = secretWord;
            this.madeMistakes = madeMistakes;
            this.maxMistakes = maxMistakes;
        }

        @Override
        public GameSession gameSessionAfterTurn() throws Exception {
            player.inform("Guess a letter: ");
            HiddenWord sw = secretWord.tryCharacter(player.guessedCharacter());
            int madeMistakes = this.madeMistakes + (sw.wrongGuess() ? 1 : 0);
            if (sw.guessed()) {
                player.inform("You won.\n");
                return new GameSession.GameOver(player);
            }
            if (madeMistakes >= maxMistakes) {
                player.inform("You lost.\n");
                return new GameSession.GameOver(player);
            } else {
                return new GameSession.MadeTurn(player, sw, madeMistakes, maxMistakes);
            }
        }
    }
}

/**
 * Turn-based game with one player
 * 
 * @author skapral
 */
interface GameSession {
    /**
     * True if the game is over
     * @return 
     */
    boolean isOver();
    
    /**
     * Make a new turn
     * 
     * @return
     * @throws Exception 
     */
    PlayerTurn newTurn() throws Exception;

    class Starting implements GameSession {

        private final HangmanPlayer player;
        private final HangmanVocabulary vocabulary;
        private final int maxMistakes;

        public Starting(HangmanPlayer player, HangmanVocabulary vocabulary, int maxMistakes) {
            this.player = player;
            this.vocabulary = vocabulary;
            this.maxMistakes = maxMistakes;
        }

        @Override
        public PlayerTurn newTurn() throws Exception {
            HiddenWord sw = vocabulary.randomWord();
            return new PlayerTurn.TryLetter(player, sw, 0, maxMistakes);
        }

        @Override
        public boolean isOver() {
            return false;
        }
    }

    class MadeTurn implements GameSession {
        private final HangmanPlayer player;
        private final HiddenWord secretWord;
        private final int madeMistakes;
        private final int maxMistakes;

        public MadeTurn(HangmanPlayer player, HiddenWord secretWord, int madeMistakes, int maxMistakes) {
            this.player = player;
            this.secretWord = secretWord;
            this.madeMistakes = madeMistakes;
            this.maxMistakes = maxMistakes;
        }

        @Override
        public PlayerTurn newTurn() throws Exception {
            // @todo: this is too messy, need to decompose it deeper
            if (secretWord.wrongGuess()) {
                player.inform(
                        String.format(
                                "Missed, mistake #%d out of %d\n",
                                madeMistakes, maxMistakes
                        )
                );
            } else {
                player.inform("Hit!\n");
            }
            secretWord.informPlayer(player);
            return new PlayerTurn.TryLetter(player, secretWord, madeMistakes, maxMistakes);
        }

        @Override
        public boolean isOver() {
            return false;
        }
    }

    class GameOver implements GameSession {

        private final HangmanPlayer player;

        public GameOver(HangmanPlayer player) {
            this.player = player;
        }

        @Override
        public PlayerTurn newTurn() throws Exception {
            throw new Exception("The game is already over");
        }

        @Override
        public boolean isOver() {
            return true;
        }
    }
}

public class Main {

    private static final String[] WORDS = {
        "simplicity", "equality", "grandmother",
        "neighborhood", "relationship", "mathematics",
        "university", "explanation"
    };

    private final HangmanPlayer player;
    private final Game game;

    public Main(HangmanPlayer player, Game game) {
        this.player = player;
        this.game = game;
    }

    public Main(final InputStream in, final OutputStream out, final int m) {
        this(new HangmanPlayer.Console(in, out),
                new Game.Hangman(
                        new HangmanVocabulary.FromArray(WORDS),
                        m
                )
        );
    }

    public static void main(final String... args) throws Exception {
        new Main(System.in, System.out, 5).exec();
    }

    public void exec() throws Exception {
        game.playSessionWith(player);
    }
}
