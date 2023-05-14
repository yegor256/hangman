package hangman;

import hangman.exceptions.WordAlreadyOpenException;

/**
 * Created by teSGreat on 24.05.2017.
 */
public interface IWordKeeper {

    boolean findLetter(char letter) throws WordAlreadyOpenException;

    boolean isOpen();
}
