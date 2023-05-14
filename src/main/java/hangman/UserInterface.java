package hangman;

import common.Media;
import common.Messages;
import common.Recipient;

import java.util.Scanner;

public final class UserInterface implements Runnable
{
    private final Media _media;
    private final Scanner _in;
    private final Messages _messages;

    private String _gallows = "";
    private String _word = "";
    private boolean _gameOver;

    public UserInterface(Messages messages, Media media, Scanner in)
    {
        _in = in;
        _media = media;
        _messages = messages;
    }

    @Override
    public void run()
    {
        _messages.subcribeTo("GameSetup", x -> playGame(x));
        _messages.subcribeTo("GameEnded", x -> gameEnded(x));
        _messages.subcribeTo("GuessedCorrectly", x -> guessed(x));
        _messages.subcribeTo("WordUpdated", x -> wordUpdated(x));
        _messages.subcribeTo("GallowsUpdated", x -> gallowsUpdated(x));
    }

    private void playGame(String result)
    {
        _gameOver = false;
        while(!_gameOver)
        {
            _media.print("The word is: " + _word);
            _media.print("Guess a letter: ");
            _messages.send("Guessed", _in.next().charAt(0) + "");
            _media.print(_gallows);
        }
    }

    private void gameEnded(String result)
    {
        _gameOver = true;
        _media.print(result.equals("won") ? "You won!\n" : "You lost.\n");
    }

    private void guessed(String correctly)
    {
        _media.print(correctly.equals("true") ? "Hit!\n\n" : "Missed.\n\n");
    }

    private void wordUpdated(String word)
    {
        _word = word;
    }

    private void gallowsUpdated(String gallows)
    {
        _gallows = gallows;
    }
}
