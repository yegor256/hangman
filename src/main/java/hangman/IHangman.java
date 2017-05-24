package hangman;

import hangman.exceptions.HitNotAllowedException;

/**
 * Created by teSGreat on 24.05.2017.
 */
public interface IHangman {

    void trySurvive();

    void hitMe(char letter) throws HitNotAllowedException;

    boolean isAlive();

    boolean winner();

    int attemptsRemained();
}
