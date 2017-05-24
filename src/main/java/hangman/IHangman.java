package hangman;

/**
 * Created by teSGreat on 24.05.2017.
 */
public interface IHangman {

    void trySurvive();

    void hitMe(char letter);

    boolean isAlive();

    boolean winner();

    int attemptsRemained();
}
