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

import hangman.core.Hangman;
import hangman.core.Round;
import hangman.secret.HardcodedVocabulary;

public final class Main {
	public final static void main(String[] args) {
		final Scanner scan = new Scanner(System.in);
		final Hangman hangman = new Hangman(new HardcodedVocabulary());
		Round currentRound, lastRound = null;
		do {
			System.out.print("Guess a letter: ");
			final char c = scan.next().charAt(0);
			currentRound = lastRound==null?hangman.disclose(c):hangman.discloseAlso(lastRound,c);
			if (currentRound.missed) {
				System.out.printf("Missed, mistake #%d out of %d\n", currentRound.mistakes, hangman.allowedMistakes);
			} else {
				System.out.println("Hit!");
			}
			System.out.println("The word: " + currentRound.currentGuess);
			lastRound = currentRound;
		} while(hangman.gameStage(lastRound) == Hangman.Stage.PLAYING);
		if (hangman.gameStage(lastRound) == Hangman.Stage.YOUWON) {
			System.out.printf("You won in %d rounds!\n", lastRound.round);
		} else {
			System.out.printf("You lost in %d rounds.\n", lastRound.round);
		}
	}
}
