package hangman;

import game.InputCharView;
import game.Lifespan;
import game.CharInput;
import game.Output;
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
        private final InputCharView in;
        private final Lifespan lifespan;
        private final Output out;

        public Attempt (final WordLetters word, final Lifespan lifespan,
            final CharInput in, final Output out) {
                this(word, lifespan, new GuessLetterInput(in, out), out);
        }

        public Attempt(final WordLetters word, final Lifespan lifespan, 
                final InputCharView in, final Output out) {                
                this.word = word;
                this.lifespan = lifespan;
                this.in =  in;
                this.out = out;
        }

        @Override
        public void promised() {
                final WordLetters updatedWord = 
                        new LettersOn(word, new WhereSymbol(in.next()));                        
                new Reactions(updatedWord, lifespan, in, out,                                
                        new Conditions(updatedWord, word, lifespan))
                .bubbled();
        }
}