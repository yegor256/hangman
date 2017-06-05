package word;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Check if the characters were turned on.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class WasLetterOn implements LetterOnCodition {
        private final WordLetters present;
        private final WordLetters past;

        public WasLetterOn(final WordLetters present, final WordLetters past) {
                this.present = present;
                this.past = past;
        }

        @Override
        public boolean confirmed() {   
                return 
                ! present.letters().stream().map(l -> Boolean.toString(l.isOn()))
                .collect(Collectors.joining(""))
                .equals(
                        past.letters().stream().map(l -> Boolean.toString(l.isOn()))
                        .collect(Collectors.joining("")));
        }      
}