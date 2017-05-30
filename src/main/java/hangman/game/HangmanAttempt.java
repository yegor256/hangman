package game;

import character.*;
import word.*;
import game.*;
import player.*;
import event.OnBase;
import event.IfBase;

/**
 * The player can attempt as many times he can until the number
 * of failures are reached or the success criterion has been
 * achived.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class HangmanAttempt implements Attempt {
	private final Word word; 
	private final Failures failures;

	public HangmanAttempt(final Word word, final Failures failures) {
		this.word = word;
		this.failures = failures;
	}

	@Override
	public void attempt() {  

        // WereLettersOn wereLetters = 
        // 	new WereLetters(
        // 		new LettersOn(new WhereSymbol('i'), word));		

        WereLettersOn wereLetters = 
        	new WereLetters(
        		new LettersOn(new WhereSymbol('i'), 
        			new Word(
        				new Characters(
        					"iiii"))));		

                            


		// new HangmanOnGuessed(new VisibleGuessed(),
		    new HangmanOnWon(new VisibleWon(),
		    	new OnBase(
		        	new HangmanIfGuessed(wereLetters,
		            	new HangmanIfWon(wereLetters,
		            		new IfBase()))))
		            			.bubbled();   					        							
	}
}