package hangman;

import word.IsLetterOn;
import word.IsWordOn;
import word.WordLetters;
import event.Dispatching;
import event.Event;
import event.IfBase;
import game.Failures;
import game.MaxInteger;
import word.LetterOnCodition;
import word.WordOnCondition;

/**
 * Conditions.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Conditions implements Dispatching {        
        private final WordOnCondition isWordOn;
        private final LetterOnCodition isLetterOn;
        private final MaxInteger maxFailures;
        private final Failures failures;        

        public Conditions(final WordLetters updatedWord, final WordLetters word, 
                final MaxInteger maxFailures, final Failures failures) {
                this.isWordOn = new IsWordOn(updatedWord);
                this.isLetterOn = new IsLetterOn(updatedWord, word);
                this.maxFailures = maxFailures;
                this.failures = failures;                
        }

        @Override
        public Event event() {                 
                return 
                new IfGuessed(isLetterOn, isWordOn,
                        new IfMissed(isLetterOn, maxFailures, failures,
                                new IfBase()))
                .event();
        }
}
