package game;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Lives implements Lifespan {        
        private final Integer max;
        private final Integer lives;

        public Lives(final Integer max) {
            this(max, max);
        }

        public Lives(final Integer max, final Integer lives) {                
                this.max = max;
                this.lives = lives;
        }

        @Override
        public Integer left() {               
               return lives;
        }        

        @Override
        public Integer total() {
                return max;
        }
}