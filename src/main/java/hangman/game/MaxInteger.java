package game;

/**
 * Predicate for checking if the message is "won".
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public interface MaxInteger {
        public boolean reached(Failures failures);
        public Integer integer();
}