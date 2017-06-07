package game;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Lives implements LivesLeft {        
        private final MaxLivesInteger max;
        private final Integer lives;

        public Lives(final Integer max, final Integer lives) {
            this(new MaxLives(max), lives);
        }

        public Lives(final MaxLivesInteger max, final Integer lives) {                
                this.max = max;
                this.lives = lives;
        }

        @Override
        public boolean still() {
               return ! max.reached(lives);
        }

        @Override
        public Integer left() {
               return max.number() - lives;
        }        

        @Override
        public Integer total() {
                return max.number();
        }
}