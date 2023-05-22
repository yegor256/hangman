package game;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class LifeTaken  implements Lifespan {
        private final Lifespan source;
        
        public LifeTaken(final Lifespan source) {
                this.source = source;
        }

        @Override
        public Integer left() {   
                return 
                source.left() > 0
                ? new Lives(source.total(), source.left()-1).left()
                : source.left();
        }

        @Override
        public Integer total() {
                return source.total();
        }        
}