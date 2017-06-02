package hangman;

import game.FailuresMessageMedia;
import view.View;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class AssignedMissedView implements game.AssignedMissedView {
        @Override
        public View with(FailuresMessageMedia media) {
                return new MissedView(media);
        }
}
