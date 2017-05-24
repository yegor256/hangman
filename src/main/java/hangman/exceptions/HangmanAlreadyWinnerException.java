package hangman.exceptions;

/**
 * Created by teSGreat on 24.5.17.
 */
public class HangmanAlreadyWinnerException extends HitNotAllowedException {
    static final long serialVersionUID = 1L;

    public HangmanAlreadyWinnerException() {
        super("Dont hit it! It already win!");
    }
}
