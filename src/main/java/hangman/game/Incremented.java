package game;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Incremented implements Failures {
        private final Integer step;
        private final Failures source;

        public Incremented(final Failures failures) {
                this(1, failures);
        }       

        public Incremented(final int step, final Failures failures) {
                this.step = step;
                this.source = failures;
        }       

        public Integer current() {
                return new PlayerFailures(source.current()+step).current();
        }
}