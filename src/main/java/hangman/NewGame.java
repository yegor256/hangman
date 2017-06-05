package hangman;

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
        private static final int DEFAULT_FAILURES = 5;
        private final NextWord words;
        private final MaxInteger maxFailures;

        public NewGame() {
                this(DEFAULT_FAILURES);         
        }

        public NewGame(final int maxFailures) {
                this(new MaxFailures(maxFailures));          
        }       

        public NewGame(final MaxInteger maxFailures) {
                this(new RandomWords(), maxFailures);              
        }               

        public NewGame(final NextWord words, final MaxInteger maxFailures) {
                this.words = words;
                this.maxFailures = maxFailures;
        }

        public void start() {
                new Attempt(words.next(), maxFailures);
        }                            
}