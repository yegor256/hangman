package hangman;

import game.Lifespan;
import game.FailuresMedia;

/**
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class FailuresMessage implements FailuresMedia {
        private final Lifespan lifespan;
        private final String message;
        
        public FailuresMessage(final Lifespan lifespan) {
                this(lifespan, "");
        }

        public FailuresMessage(final Lifespan lifespan, final String message) {
                this.lifespan = lifespan;
                this.message = message;
        }       

        @Override
        public FailuresMedia withCurrent(String template) {
                return 
                new FailuresMessage(lifespan, message
                        +String.format(template, lifespan.total()-lifespan.left()));                                
        }

        @Override
        public FailuresMedia withText(String text) {
                return 
                new FailuresMessage(lifespan, message+text);
        }       

        @Override
        public FailuresMedia withMax(String template) {
                return 
                new FailuresMessage(lifespan, message
                        +String.format(template, lifespan.total()));
        }       

        @Override
        public String formatted() {
                return message;
        }
}