package hangman;

import common.Messages;
import common.Recipient;

import java.util.concurrent.atomic.AtomicInteger;

public final class Gallows implements Runnable
{
    private final Messages _messages;
    private final Recipient _guessed;

    private AtomicInteger _mistakes;
    private int _max;

    public Gallows(Messages messages, int max)
    {
        _messages = messages;
        _guessed = x -> guessed(x);
        _mistakes = new AtomicInteger();
        _max = max;
    }

    @Override
    public void run()
    {
        _messages.subcribeTo("GuessedCorrectly", _guessed);
    }

    private void guessed(String correctly)
    {
        if(!correctly.equals("true"))
            _messages.send("ShowUser", String.format("Mistake #%d out of %d\n", _mistakes.incrementAndGet(), _max));
        checkForGameEnd();
    }

    private void checkForGameEnd()
    {
        if (_mistakes.get() == _max)
            _messages.send("GameEnded", "lost");
    }
}
