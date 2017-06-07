package hangman;

import game.Output;
import view.View;
import view.EmptyView;
import word.LetterView;
import word.WordLetters;
import java.util.stream.Collectors;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class NewAttemptView implements View {
        private final WordLetters word;
        private final Output output;
        private final View source;

        public NewAttemptView(final Output output, final WordLetters word) {
                this(output, word, new EmptyView());
        }        

        public NewAttemptView(final Output output, final WordLetters word, 
                final View source) {
                this.output = output;
                this.word = word;
                this.source = source;
        }

        @Override
        public void show() {
                source.show();
                output.display(
                        String.format(
                                "\n The word: %s\n\n", 
                                word.letters().stream()
                                .map(letter -> String.valueOf(new LetterView(letter).symbol()))
                                .collect(Collectors.joining(""))
                        )
                );
        }
}