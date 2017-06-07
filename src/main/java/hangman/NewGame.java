package hangman;

import java.util.stream.Collectors;
import game.CharInput;
import game.Output;
import game.MaxInteger;
import game.MaxFailures;
import word.NextWord;
import word.RandomWords;
import word.NextWord;
import word.RandomWords;

/**
 * Initialization and starting a new game.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class NewGame implements game.NewGame {
        private static final int DEFAULT_FAILURES = 7;
        private final NextWord words;
        private final MaxInteger maxFailures;
        private final CharInput charInput;
        private final Output output;        

        public NewGame(CharInput charInput, Output output) {
                this(DEFAULT_FAILURES, charInput, output);         
        }

        public NewGame(final int maxFailures, final CharInput charInput,
                final Output output) {
                this(new MaxFailures(maxFailures), charInput, output);          
        }       

        public NewGame(final MaxInteger maxFailures, final CharInput charInput,
                final Output output) {
                this(new RandomWords(), maxFailures, charInput, output);              
        }               

        public NewGame(final NextWord words, final MaxInteger maxFailures, 
                final CharInput charInput, final Output output) {
                this.words = words;
                this.maxFailures = maxFailures;                
                this.charInput = charInput;
                this.output = output;
        }

        public void start() {                
                new Attempt(words.next(), maxFailures, charInput, output).promised();
        }                            
}