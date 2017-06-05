package hangman;

import game.IncrementedFailures;
import game.Failures;
import game.MaxInteger;
import game.FailuresMedia;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class FailuresMessage implements FailuresMedia {
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
        public FailuresMedia withCurrent(String template) {
                return 
                new FailuresMessage(maxFailures, failures, 
                        message+String.format(template, new IncrementedFailures(failures).current()));
        }

        @Override
        public FailuresMedia withText(String text) {
                return 
                new FailuresMessage(maxFailures, failures, message+text);
        }       

        @Override
        public FailuresMedia withMax(String template) {
                return 
                new FailuresMessage(maxFailures, failures, 
                        message+String.format(template, maxFailures.number()));
        }       

        @Override
        public String formatted() {
                return message;
        }
}