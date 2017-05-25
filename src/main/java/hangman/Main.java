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

interface GuessedWord {

    boolean falseTry();

    boolean guessed();

    GuessedWord tryCharacter(char c);

    void informPlayer(Player p);

    class Init implements GuessedWord {

        private final String secret;

        public Init(String secret) {
            this.secret = secret;
        }

        @Override
        public boolean falseTry() {
            return false;
        }

        @Override
        public boolean guessed() {
            return false;
        }

        @Override
        public GuessedWord tryCharacter(char c) {
            boolean visible[] = new boolean[secret.length()];
            boolean hit = false;
            for (int i = 0; i < secret.length(); ++i) {
                if (secret.charAt(i) == c && !visible[i]) {
                    visible[i] = true;
                    hit = true;
                }
            }
            return new Attempt(secret, visible, !hit);
        }

        @Override
        public void informPlayer(Player p) {
            p.inform("The word: ");
            p.inform(secret.replaceAll(".", "?"));
            p.inform("\n\n");
        }
    }

    class Attempt implements GuessedWord {

        private final String secret;
        private final boolean[] visible;
        private final boolean falseTry;

        public Attempt(String secret, boolean[] visible, boolean falseTry) {
            this.secret = secret;
            this.visible = visible;
            this.falseTry = falseTry;
        }

        @Override
        public boolean falseTry() {
            return falseTry;
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
        public GuessedWord tryCharacter(char c) {
            boolean visible[] = Arrays.copyOf(this.visible, this.visible.length);
            boolean hit = false;
            for (int i = 0; i < secret.length(); ++i) {
                if (secret.charAt(i) == c && !visible[i]) {
                    visible[i] = true;
                    hit = true;
                }
            }
            return new Attempt(secret, visible, !hit);
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

    GuessedWord randomWord();

    class FromArray implements Vocabulary {

        private final String[] words;

        public FromArray(String[] words) {
            this.words = words;
        }

        @Override
        public GuessedWord randomWord() {
            return new GuessedWord.Init(
                    words[new Random().nextInt(words.length)]
            );
        }
    }
}

interface Game {

    void playSessionWith(Player player) throws Exception;

    class StandardRules implements Game {

        private final Vocabulary vocabulary;
        private final int maxMistakes;

        public StandardRules(Vocabulary vocabulary, int maxMistakes) {
            this.vocabulary = vocabulary;
            this.maxMistakes = maxMistakes;
        }

        @Override
        public void playSessionWith(Player player) throws Exception {
            GameSession gs = new GameSession.Starting(player, vocabulary, maxMistakes);
            while (!gs.isOver()) {
                gs = gs.advanced();
            }
            gs.advanced(); // @todo: cheaty treak, makes contract of GameSession not so obvious. Try to remove
        }
    }
}

interface GameSession {
    boolean isOver();
    GameSession advanced() throws Exception;

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
        public GameSession advanced() throws Exception {
            // @todo: this is too messy, need to decompose it deeper
            GuessedWord sw = vocabulary.randomWord();
            player.inform("Guess a letter: ");
            sw = sw.tryCharacter(player.guessedCharacter());
            if (sw.guessed()) {
                return new GameSession.Won(player);
            }
            if (maxMistakes > 1) {
                return new GameSession.MadeTurn(player, sw, sw.falseTry() ? 1 : 0, maxMistakes);
            } else {
                return new GameSession.Lost(player);
            }
        }

        @Override
        public boolean isOver() {
            return false;
        }
    }

    class MadeTurn implements GameSession {

        private final Player player;
        private final GuessedWord secretWord;
        private final int madeMistakes;
        private final int maxMistakes;

        public MadeTurn(Player player, GuessedWord secretWord, int madeMistakes, int maxMistakes) {
            this.player = player;
            this.secretWord = secretWord;
            this.madeMistakes = madeMistakes;
            this.maxMistakes = maxMistakes;
        }

        @Override
        public GameSession advanced() throws Exception {
            // @todo: this is too messy, need to decompose it deeper
            if (secretWord.falseTry()) {
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
            player.inform("Guess a letter: ");
            GuessedWord sw = secretWord.tryCharacter(player.guessedCharacter());
            int madeMistakes = this.madeMistakes + (sw.falseTry() ? 1 : 0);
            if (sw.guessed()) {
                return new GameSession.Won(player);
            }
            if (madeMistakes >= maxMistakes) {
                return new GameSession.Lost(player);
            } else {
                return new GameSession.MadeTurn(player, sw, madeMistakes, maxMistakes);
            }
        }

        @Override
        public boolean isOver() {
            return false;
        }
    }

    class Won implements GameSession {

        private final Player player;

        public Won(Player player) {
            this.player = player;
        }

        @Override
        public GameSession advanced() {
            player.inform("You won.\n");
            return this;
        }

        @Override
        public boolean isOver() {
            return true;
        }
    }

    class Lost implements GameSession {

        private final Player player;

        public Lost(Player player) {
            this.player = player;
        }

        @Override
        public GameSession advanced() {
            player.inform("You lost.\n");
            return this;
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
        this(
                new Player.Console(in, out),
                new Game.StandardRules(
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

    /*public void exec() {
        String word = WORDS[new Random().nextInt(WORDS.length)];
        boolean[] visible = new boolean[word.length()];
        int mistakes = 0;
        try (final PrintStream out = new PrintStream(this.output)) {
            final Iterator<String> scanner = new Scanner(this.input);
            boolean done = true;
            while (mistakes < this.max) {
                done = true;
                for (int i = 0; i < word.length(); ++i) {
                    if (!visible[i]) {
                        done = false;
                    }
                }
                if (done) {
                    break;
                }
                out.print("Guess a letter: ");
                char chr = scanner.next().charAt(0);
                boolean hit = false;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) == chr && !visible[i]) {
                        visible[i] = true;
                        hit = true;
                    }
                }
                if (hit) {
                    out.print("Hit!\n");
                } else {
                    out.printf(
                            "Missed, mistake #%d out of %d\n",
                            mistakes + 1, this.max
                    );
                    ++mistakes;
                }
                out.append("The word: ");
                for (int i = 0; i < word.length(); ++i) {
                    if (visible[i]) {
                        out.print(word.charAt(i));
                    } else {
                        out.print("?");
                    }
                }
                out.append("\n\n");
            }
            if (done) {
                out.print("You won!\n");
            } else {
                out.print("You lost.\n");
            }
        }
    }*/
}
