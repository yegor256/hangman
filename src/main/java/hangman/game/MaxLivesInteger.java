package game;

/**
 * Predicate for checking if the message is "won".
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public interface MaxLivesInteger {
        public boolean reached(Integer number);
        public Integer number();
}