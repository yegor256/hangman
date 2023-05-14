package hangman;

import common.Messages;

import java.util.concurrent.atomic.AtomicInteger;

public final class Gallows implements Runnable
{
    private final Messages _messages;

    private AtomicInteger _mistakes;
    private MistakeMax _max;

    public Gallows(Messages messages, MistakeMax max)
    {
        _messages = messages;
        _mistakes = new AtomicInteger();
        _max = max;
    }

    @Override
    public void run()
    {
        _messages.subcribeTo("GuessedCorrectly", x -> guessed(x));
    }

    private void guessed(String correctly)
    {
        if(!correctly.equals("true"))
            _messages.send("GallowsUpdated", String.format("Mistakes: #%d out of %d\n",
                _mistakes.incrementAndGet(), _max.intValue()));
        checkForGameEnd();
    }

    private void checkForGameEnd()
    {
        if (_mistakes.get() == _max.intValue())
            _messages.send("GameEnded", "lost");
    }
}
