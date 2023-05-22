package hangman;

import word.IsLetterOn;
import word.IsWordOn;
import word.WordLetters;
import event.Dispatching;
import event.Event;
import event.IfBase;
import game.Lifespan;
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
        private final Lifespan lifespan;

        public Conditions(final WordLetters updatedWord, final WordLetters word, 
                final Lifespan lifespan) {
                this.isWordOn = new IsWordOn(updatedWord);
                this.isLetterOn = new IsLetterOn(updatedWord, word);
                this.lifespan = lifespan;
        }

        @Override
        public Event event() {                 
                return 
                new IfGuessed(isLetterOn, isWordOn,
                        new IfMissed(isLetterOn, lifespan,
                                new IfBase()))
                .event();
        }
}
