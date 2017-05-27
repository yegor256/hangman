package hangman;

import common.Messages;
import common.Recipient;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Secret implements Runnable
{
    private final Messages _messages;
    private final Recipient _start;
    private final Recipient _guessed;

    private String _word;
    private List<Boolean> _discovered;

    public Secret(Messages messages)
    {
        _messages = messages;
        _start = x -> startGame(x);
        _guessed = x -> guess(x);
    }

    @Override
    public void run()
    {
        _messages.subcribeTo("GameStarted", _start);
        _messages.subcribeTo("Guessed", _guessed);
    }

    private void startGame(String result)
    {
        _word = result;
        _discovered = _word.chars().mapToObj(x -> false).collect(Collectors.toList());
        _messages.send("ShowUser", publicWord());
        _messages.send("GameSetup", "true");
    }

    private void guess(String guess)
    {
        String result = guessedCorrectly(guess);
        _messages.send("ShowUser", publicWord());
        _messages.send("GuessedCorrectly", result);
        checkForGameEnd();
    }

    private void checkForGameEnd()
    {
        if (_discovered.stream().allMatch(x -> x))
            _messages.send("GameEnded", "won");
    }

    private String publicWord()
    {
        return "The word: " + String.join("", IntStream.range(0, _word.length())
            .mapToObj(i -> _discovered.get(i) ? _word.substring(i, i + 1) : "?")
            .collect(Collectors.toList())) + "\n";
    }

    private String guessedCorrectly(String guess)
    {
        String result = "false";
        for (int i = 0; i < _word.length(); ++i) {
            if (_word.charAt(i) == guess.charAt(0) && !_discovered.get(i)) {
                _discovered.set(i, true);
                result = "true";
            }
        }
        return result;
    }
}
