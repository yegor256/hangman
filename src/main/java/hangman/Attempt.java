package hangman;

import game.CharInput;
import game.Output;
import game.Failures;
import game.MaxInteger;
import game.PlayerFailures;
import word.LettersOn;
import word.WordLetters;
import word.WhereSymbol;

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
        private final CharInput in;
        private final Output out;

        public Attempt (final WordLetters word, final MaxInteger maxFailures,
            final CharInput in, final Output out) {
                this(word, maxFailures, new PlayerFailures(), 
                    new GuessLetterInput(in, out), out);
        }

        public Attempt(final WordLetters word, final MaxInteger maxFailures, 
                Failures failures, final CharInput in, final Output out) {                
                this.word = word;
                this.maxFailures = maxFailures;
                this.failures = failures;
                this.in = in;
                this.out = out;
        }

        @Override
        public void promised() {
                final WordLetters updatedWord = 
                        new LettersOn(word, new WhereSymbol(in.next()));

                new Reactions(updatedWord, maxFailures, failures, in, out,                                
                        new Conditions(updatedWord, word, maxFailures, failures))
                .bubbled();
        }
}