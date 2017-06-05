package hangman;

import game.Output;
import game.FailuresMedia;
import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class MissedView implements View {
        private final Output output; 
        private final FailuresMedia media;           

        public MissedView(final Output output, final FailuresMedia media) {                
                this.output = output;
                this.media = media;
        }

        @Override
        public void show() {
                output.display(
                       media 
                        .withText("Missed, mistake ")
                        .withText("out of ")
                        .withMax("#%d")
                        .formatted());
        }
}