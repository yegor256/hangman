package hangman;

/**
 * Random word.
 */
public interface AbstractRandomWord {
    /**
     * Available words.
     *
     * @return Available words
     */
    AbstractWord[] words();

    /**
     * Choose one of available words.
     *
     * @throws Exception When something is wrong
     */
    AbstractWord random() throws Exception;
}
