package hangman;

import game.Lifespan;
import game.Lives;
import game.CharInput;
import game.Output;
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
        private final Lifespan lifespan;
        private final CharInput charInput;
        private final Output output;        

        public NewGame(CharInput charInput, Output output) {
                this(DEFAULT_FAILURES, charInput, output);         
        }

        public NewGame(final int maxFailures, final CharInput charInput,
                final Output output) {
                this(new Lives(maxFailures), charInput, output);          
        }       

        public NewGame(final Lifespan lifespan, final CharInput charInput,
                final Output output) {
                this(new RandomWords(), lifespan, charInput, output);              
        }               

        public NewGame(final NextWord words, final Lifespan lifespan, 
                final CharInput charInput, final Output output) {
                this.words = words;
                this.lifespan = lifespan;                
                this.charInput = charInput;
                this.output = output;
        }

        public void start() {                
                new Attempt(words.next(), lifespan, charInput, output).promised();
        }                            
}