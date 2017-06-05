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
        private final Output output;
        private final CharInput charInput;

        public NewGame(Output output, CharInput charInput) {
                this(DEFAULT_FAILURES, output, charInput);         
        }

        public NewGame(final int maxFailures, final Output output, 
                final CharInput charInput) {
                this(new MaxFailures(maxFailures), output, charInput);          
        }       

        public NewGame(final MaxInteger maxFailures, final Output output, 
                final CharInput charInput) {
                this(new RandomWords(), maxFailures, output, charInput);              
        }               

        public NewGame(final NextWord words, final MaxInteger maxFailures, 
                final Output output, final CharInput charInput) {
                this.words = words;
                this.maxFailures = maxFailures;
                this.output = output;
                this.charInput = charInput;
        }

        public void start() {                
                new Attempt(words.next(), maxFailures, output, charInput).promised();
        }                            
}