package word;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Turning on the matched letters.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class LettersOn implements LettersOnAction {       
        private final WhereSymbolIs ifSymbolIs;
        private final WordLetters source;
        
        public LettersOn(final WordLetters source, final WhereSymbolIs ifSymbolIs) {
                this.ifSymbolIs = ifSymbolIs;
                this.source = source;
        }

        @Override
        public List<LetterState> letters() {            
                return source.letters();
        }

        @Override
        public List<LetterState> lettersOn() {          
                return 
                source
                .letters()
                .stream()
                .map(letter -> new LetterOn(letter, ifSymbolIs).letter())
                .collect(Collectors.toList());
        }
}
