package hangman;

import game.FailuresMedia;
import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class MissedView implements View {
        private final FailuresMedia media;    

        public MissedView(final FailuresMedia media) {
                this.media = media;
        }

        @Override
        public void show() {
                System.out.println(
                       media 
                        .withText("Missed, mistake ")
                        .withText("out of ")
                        .withMax("#%d")
                        .formatted());
        }
}