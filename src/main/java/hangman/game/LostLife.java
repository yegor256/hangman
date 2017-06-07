package game;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class LostLife  implements ReducedLifespan {
        private final LivesLeft source;
        
        public LostLife(final LivesLeft source) {
                this.source = source;
        }

        public LivesLeft lives() {
                return new Lives(source.total(), source.left()-1);
        }
}