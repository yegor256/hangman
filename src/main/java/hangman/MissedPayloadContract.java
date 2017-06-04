package hangman;

import game.Failures;
import game.FailuresMessageMedia;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public interface MissedPayloadContract {        
        public Failures failures();
        public FailuresMessageMedia media();
}