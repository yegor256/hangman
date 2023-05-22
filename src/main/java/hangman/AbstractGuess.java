package hangman;

/**
 * AbstractGuess.
 */
public interface AbstractGuess {
    /**
     * AbstractWord.
     *
     * @return AbstractWord
     */
    AbstractWord word();

    /**
     * Letter in the word.
     *
     * @return Letter in the word
     */
    Character character();

    /**
     * Is letter guessed?
     *
     * @return true if the guessed letter
     * @throws Exception When something is wrong
     */
    boolean guessed() throws Exception;
}
