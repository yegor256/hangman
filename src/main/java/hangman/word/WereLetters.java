package word;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Check if the characters were turned on.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class WereLetters implements WereLettersOn {
        private final LettersOnAction source;

        public WereLetters(final LettersOnAction source) {
                this.source = source;
        }

        @Override
        public boolean on() {   
                return 
                ! source.letters().stream().map(
                        letter -> Boolean.toString(letter.isOn())).collect(Collectors.joining("")
                        )
                        .equals(
                                source.lettersOn().stream().map(
                                        letter -> Boolean.toString(letter.isOn())).collect(Collectors.joining(""))
                                );
                }

                @Override
                public boolean allOn() {
                        return
                        source.lettersOn()
                        .stream().filter(letter -> !letter.isOn()).collect(Collectors.toList())
                        .size() == 0;
                }       
        }