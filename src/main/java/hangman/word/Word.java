package word;

import java.util.List;
import java.util.stream.Collectors;
import character.CharactersList;

/**
 * Keeping the state of a word.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Word implements WordLetters {
        private final CharactersList source;

        public Word(final CharactersList source) {
                this.source = source;
        }

        @Override
        public List<LetterState> letters() {
                return 
                source
                .list()
                .stream()
                .map(letter -> new Letter(letter))
                .collect(Collectors.toList());
        }
}