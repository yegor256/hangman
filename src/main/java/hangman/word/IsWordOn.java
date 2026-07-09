package word;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Check if all the letters were turned on in the word.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IsWordOn implements WordOnCondition {
        private final WordLetters present;

        public IsWordOn(final WordLetters present) {
                this.present = present;
        }

        @Override
        public boolean confirmed() {
                return
                present.letters().stream()
                .filter(letter -> !letter.isOn()).collect(Collectors.toList())
                .size() == 0;
        }       
}