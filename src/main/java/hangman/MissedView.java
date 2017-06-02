package hangman;

import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class MissedView implements View {
        private final FailuresMessageMedia message;    

        public MissedView(FailuresMessageMedia message) {
                this.message = message;
        }

        @Override
        public void show() {
                System.out.println(
                        message
                        .withText("Missed, mistake ")
                        .withCurrent("#%d ")
                        .withText("out of ")
                        .withMax("#%d")
                        .formatted());
        }
}