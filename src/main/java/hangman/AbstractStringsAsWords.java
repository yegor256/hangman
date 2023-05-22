package hangman;

/**
 * Strings as words.
 */
public interface AbstractStringsAsWords {
    /**
     * Original strings.
     *
     * @return Original strings
     */
    String[] strings();

    /**
     * Convert original strings to words.
     *
     * @return Original strings as words
     */
    AbstractWord[] toWords();
}
