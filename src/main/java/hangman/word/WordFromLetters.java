package word;

import java.util.List;

/**
 * Keeping the state of a word.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class WordFromLetters implements WordLetters {
        private final List<LetterState> source;

        public WordFromLetters(final List<LetterState> source) {
                this.source = source;
        }

        @Override
        public List<LetterState> letters() {
                return source;
        }
}