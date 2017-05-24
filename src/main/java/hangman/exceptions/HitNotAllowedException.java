package hangman.exceptions;

/**
 * Created by teSGreat on 24.5.17.
 */
public class HitNotAllowedException extends Exception {
    static final long serialVersionUID = 1L;

    public HitNotAllowedException(String message) {
        super(message);
    }
}
