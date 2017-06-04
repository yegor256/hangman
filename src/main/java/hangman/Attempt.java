package hangman;

import game.PlayerFailures;
import game.MaxInteger;
import character.Characters;
import event.OnBase;
import event.IfBase;
import word.*;

/**
 * The player can attempt as many times he can until the number
 * of failures are reached or the success criterion has been
 * achived.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Attempt implements game.Attempt {
        private final Word word;
        private final MaxInteger maxFailures;

        public Attempt(final Word word, final MaxInteger maxFailures) {
                this.word = word;
                this.maxFailures = maxFailures;
        }

        @Override
        public void attempt() {
                // Prod
                // WereLettersOn wereLetters =
                //      new WereLetters(
                //              new LettersOn(new WhereSymbol('i'), word));

                // Test: you hit!
                // WereLettersOn wereLetters =
                //      new WereLetters(
                //              new LettersOn(new WhereSymbol('i'),
                //                      new Word(
                //                              new Characters(
                //                                      "simplicity"))));

                // Test: you won!
                // WereLettersOn wereLetters =
                //      new WereLetters(
                //              new LettersOn(new WhereSymbol('i'),
                //                      new Word(
                //                              new Characters(
                //                                      "iiii"))));

                // Test: you missed it!
                WereLettersOn wereLetters =
                new WereLetters(
                        new LettersOn(new WhereSymbol('a'),
                                new Word(
                                        new Characters(
                                                "simplicity"))));
                
                // new OnNewAttempt(new NewAttemptView(),
                        // new OnLost(new LostView(),
                                new OnMissed(new AssignedMissedView(),
                                        new OnGuessed(new GuessedView(),
                                                new OnWon(new WonView(),
                                                        new OnBase(
                                                                // new IfLost(
                                                                        new IfMissed(wereLetters, maxFailures, new PlayerFailures(),
                                                                                new IfGuessed(wereLetters,
                                                                                        new IfWon(wereLetters,
                                                                                                new IfBase())))))))
                .bubbled();                        
        }
}