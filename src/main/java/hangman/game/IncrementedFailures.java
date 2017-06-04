package game;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IncrementedFailures implements Failures {
        private final Integer step;
        private final Failures source;

        public IncrementedFailures(final Failures failures) {
                this(1, failures);
        }       

        public IncrementedFailures(final int step, final Failures failures) {
                this.step = step;
                this.source = failures;
        }       

        public Integer current() {
                return new PlayerFailures(source.current()+step).current();
        }
}