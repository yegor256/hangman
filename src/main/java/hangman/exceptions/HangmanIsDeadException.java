package hangman.exceptions;

/**
 * Created by teSGreat on 24.5.17.
 */
public class HangmanIsDeadException extends HitNotAllowedException {
    static final long serialVersionUID = 1L;

    public HangmanIsDeadException() {
        super("Dont hit it! It already dead!");
    }
}
