package hangman;

import game.CharInput;
import game.Output;
import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class GuessLetterInput implements CharInput {        
        private final CharInput charInput;
        private final Output output;

        public GuessLetterInput(final CharInput charInput, final Output output) {                
                this.charInput = charInput;
                this.output = output;
        }

        @Override
        public char next() {
                output.display("Guess a letter: ");
                return charInput.next();
        }
}