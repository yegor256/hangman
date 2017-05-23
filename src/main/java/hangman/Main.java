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

import java.util.Scanner;

public final class Main {
	public final static void main( String[] args ) {
		final Scanner scan = new Scanner(System.in);
		final Hangman hangman = new Hangman(new HardcodedVocabulary());
		while(hangman.gameStage() == Hangman.Stage.PLAYING) {
            System.out.print("Guess a letter: ");
            final char c = scan.next().charAt(0);
            final GuessRound round = hangman.discover(c);
            if( round.missed ) {
            	System.out.printf("Missed, mistake #%d out of %d\n", round.mistakes, hangman.allowedMistakes);
            } else {
            	System.out.println("Hit!");
            }
            // Replace non-printable NULL characters with CLI friendly alternative
            final String printableHints = round.partialSolution.replace('\0','_');
            System.out.println("The word: " + printableHints);
		}
		if(hangman.gameStage() == Hangman.Stage.YOUWON) {
            System.out.println("You won!");
		} else {
			System.out.println("You lost.\n");
		}
    }
}
