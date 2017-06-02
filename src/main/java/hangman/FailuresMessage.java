package hangman;

import game.FailuresMessageMedia;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class FailuresMessage implements FailuresMessageMedia {
        private final MaxInteger maxFailures;
        private final Failures failures;
        private final String message;
        
        public FailuresMessage(final MaxInteger maxInteger, 
                        final Failures failures) {
                this(maxInteger, failures, "");
        }

        public FailuresMessage(final MaxInteger maxInteger, 
                        final Failures failures, final String message) {
                this.maxFailures = maxInteger;
                this.failures = failures;
                this.message = message;
        }       

        @Override
        public FailuresMessage withCurrent(String template) {
                return 
                new FailuresMessage(maxFailures, failures, 
                        message+String.format(template, failures.current()));
        }

        @Override
        public FailuresMessage withText(String text) {
                return 
                new FailuresMessage(maxFailures, failures, message+text);
        }       

        @Override
        public FailuresMessage withMax(String template) {
                return 
                new FailuresMessage(maxFailures, failures, 
                        message+String.format(template, maxFailures.number()));
        }       

        @Override
        public String formatted() {
                return message;
        }
}