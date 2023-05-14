package hangman.exceptions;

/**
 * Created by teSGreat on 24.05.2017.
 */
public class WordAlreadyOpenException extends Exception {
    static final long serialVersionUID = 1L;

    public WordAlreadyOpenException() {
        super("You alreary open the word!");
    }
}
