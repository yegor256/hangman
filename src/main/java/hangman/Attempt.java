package hangman;

import game.CharInput;
import game.Output;
import view.View;
import event.OnBase;
import event.IfBase;
import game.Failures;
import game.MaxInteger;
import game.PlayerFailures;
import word.IsWordOn;
import word.LettersOn;
import word.WasLetterOn;
import word.WordLetters;
import word.WhereSymbol;
import word.LetterOnCodition;

/**
 * The player can attempt as many times he can until the number
 * of failures are reached or the success criterion has been
 * achived.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Attempt implements game.Attempt {        
        private final WordLetters word;
        private final MaxInteger maxFailures;
        private final Failures failures;
        private final CharInput input;
        private final Output output;

        public Attempt (final WordLetters word, final MaxInteger maxFailures,
            final CharInput input, final Output output) {
                this(word, maxFailures, new PlayerFailures(), 
                    new GuessLetterInput(input, output), output);
        }

        public Attempt(final WordLetters word, final MaxInteger maxFailures, 
                Failures failures, final CharInput input, 
                final Output output) {                
                this.word = word;
                this.maxFailures = maxFailures;
                this.failures = failures;
                this.input = input;
                this.output = output;
        }

        @Override
        public void promised() {
                 // new Reactions(word, updatedWord = 
                 //                new LettersOn(
                 //                    word, new WhereSymbol(input.next())
                 //                ), maxFailures, failures, input, output,                                
                 //        new Events(updatedWord, word, maxFailures, failures))                

                // Integrate in this present assignment.
                final WordLetters updatedWord = new LettersOn(word, new WhereSymbol(input.next()));
                // Go to inside conditions.
                final LetterOnCodition wasLetterOn = new WasLetterOn(updatedWord, word);
                // Go to the reactions.
                final View missedView = new MissedView(output, new FailuresMessage(maxFailures, failures));
                // Integrate maxFailures with failures as failures.

                new OnWon(new WonView(output),
                        new OnLost(new LostView(output, missedView),
                                new OnGuessed(new NewAttemptView(output, updatedWord, new GuessedView(output)), 
                                        updatedWord, maxFailures, failures, input, output,
                                        new OnMissed(new NewAttemptView(output, updatedWord, missedView), 
                                                updatedWord, maxFailures, failures, input, output,
                                                // Go to the the constructor of reactions.
                                                new OnBase(
                                                        new IfGuessed(wasLetterOn, new IsWordOn(updatedWord),
                                                                new IfMissed(wasLetterOn, maxFailures, failures,
                                                                        // Go to the constructor of conditions
                                                                        new IfBase())))))))
                .bubbled();
        }
}