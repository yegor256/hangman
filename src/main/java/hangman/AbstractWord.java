package hangman;

/**
 * AbstractWord.
 */
public interface AbstractWord {
    /**
     * Original word.
     *
     * @return Original word
     */
    String original();

    /**
     * Mask symbol that displayed instead of unguessed letters
     *
     * @return Mask symbol
     */
    Character symbol();

    /**
     * The word with replaced unguessed letters to mask symbol.
     *
     * @return Masked word
     */
    String word();

    /**
     * Check that word contains letter.
     *
     * @param character Letter
     * @return True if word contains letter
     * @throws Exception When something is wrong
     */
    boolean contains(Character character) throws Exception;

    /**
     * Check that word is guessed
     * @return true if all letters of word is guessed
     * @throws Exception When something is wrong
     */
    boolean guessed() throws Exception;

    /**
     * Open letter by value.
     *
     * @param character Letter
     * @throws Exception When something is wrong
     */
    void open(Character character) throws Exception;

    /**
     * Check that letter is opened.
     *
     * @param character Letter
     * @return tue if letter is opened
     */
    boolean opened(Character character);
}
