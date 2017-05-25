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
    void informPlayer(Player p);

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
        public void informPlayer(Player p) {
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
        public void informPlayer(Player p) {
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

interface Player {
    void inform(Object str);
    char guessedCharacter() throws Exception;

    class Console implements Player {

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

interface Vocabulary {
    HiddenWord randomWord();

    class FromArray implements Vocabulary {
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
    void playSessionWith(Player player) throws Exception;

    class Hangman implements Game {
        private final Vocabulary vocabulary;
        private final int maxMistakes;

        public Hangman(Vocabulary vocabulary, int maxMistakes) {
            this.vocabulary = vocabulary;
            this.maxMistakes = maxMistakes;
        }

        @Override
        public void playSessionWith(Player player) throws Exception {
            GameSession gs = new GameSession.Starting(player, vocabulary, maxMistakes);
            while (!gs.isOver()) {
                gs = gs.newTurn().gameSessionAfterTurn();
            }
        }
    }
}

interface PlayerTurn {
    GameSession gameSessionAfterTurn() throws Exception;
    
    class TryLetter implements PlayerTurn {
        private final Player player;
        private final HiddenWord secretWord;
        private final int madeMistakes;
        private final int maxMistakes;

        public TryLetter(Player player, HiddenWord secretWord, int madeMistakes, int maxMistakes) {
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


interface GameSession {
    boolean isOver();
    PlayerTurn newTurn() throws Exception;

    class Starting implements GameSession {

        private final Player player;
        private final Vocabulary vocabulary;
        private final int maxMistakes;

        public Starting(Player player, Vocabulary vocabulary, int maxMistakes) {
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
        private final Player player;
        private final HiddenWord secretWord;
        private final int madeMistakes;
        private final int maxMistakes;

        public MadeTurn(Player player, HiddenWord secretWord, int madeMistakes, int maxMistakes) {
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

        private final Player player;

        public GameOver(Player player) {
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

    private final Player player;
    private final Game game;

    public Main(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    public Main(final InputStream in, final OutputStream out, final int m) {
        this(new Player.Console(in, out),
                new Game.Hangman(
                        new Vocabulary.FromArray(WORDS),
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
