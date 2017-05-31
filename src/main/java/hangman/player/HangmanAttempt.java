package player;

import game.GuessedView;
import character.Characters;
import event.OnBase;
import event.IfBase;
import word.*;
import game.*;

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


		// Test you hit!
        WereLettersOn wereLetters = 
        	new WereLetters(
        		new LettersOn(new WhereSymbol('i'), 
        			new Word(
        				new Characters(
        					"simplicity"))));		                            


		// Test you won!
        // WereLettersOn wereLetters = 
        // 	new WereLetters(
        // 		new LettersOn(new WhereSymbol('i'), 
        // 			new Word(
        // 				new Characters(
        // 					"iiii"))));		                            


		new HangmanOnGuessed(new GuessedView(),
		    new HangmanOnWon(new WonView(),
		    	new OnBase(
		        	new HangmanIfGuessed(wereLetters,
		        		new HangmanIfWon(wereLetters,
		            		new IfBase())))))
		            			.bubbled();   					        							
	}
}