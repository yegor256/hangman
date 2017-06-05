package hangman;

import word.WordLetters;
import java.util.stream.Collectors;
import word.LetterView;
import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class NewAttemptView implements View {
        private final WordLetters word;
        private final View source;

        public NewAttemptView(final WordLetters word, final View source) {
                this.word = word;
                this.source = source;
        }

        @Override
        public void show() {
                source.show();
                System.out.println(
                        String.format(
                                "\n The word: %s\n\n", 
                                word.letters().stream()
                                .map(letter -> new LetterView(letter).symbol())
                                .collect(Collectors.joining(""))
                        )
                );
        }
}