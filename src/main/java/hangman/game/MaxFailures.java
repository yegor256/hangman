package game;

/**
 * Predicate for checking if the message is "won".
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class MaxFailures implements MaxInteger {
        private final Integer max;
        
        public MaxFailures(final Integer max) {
                this.max = max;
        }

        public boolean reached(Failures failures) {
                return failures.current() >  max;
        }

        public Integer number() {
                return max;
        }
}