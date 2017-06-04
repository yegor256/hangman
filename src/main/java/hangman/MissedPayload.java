package hangman;

import game.FailuresMessageMedia;
import game.Failures;
import game.MaxInteger;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class MissedPayload implements MissedPayloadContract {
        private final MaxInteger maxFailures;
        private final Failures failures;

        public MissedPayload(final MaxInteger maxFailures, final Failures failures) {
                this.maxFailures = maxFailures;
                this.failures = failures;
        }

        @Override
        public Failures failures() {
                return failures;
        }

        @Override
        public FailuresMessageMedia media() {
                return new FailuresMessage(maxFailures, failures);
        }
}