package hangman;

import common.Media;
import common.Messages;
import common.Recipient;

import java.util.Scanner;

public final class UserInterface implements Runnable
{
    private final Media _media;
    private final Scanner _in;
    private final Recipient _end;
    private final Recipient _start;
    private final Recipient _guessed;
    private final Recipient _showUser;
    private final Messages _messages;

    private boolean _gameOver;

    public UserInterface(Messages messages, Media media, Scanner in)
    {
        _in = in;
        _media = media;
        _messages = messages;
        _start = x -> playGame(x);
        _end = x -> gameEnded(x);
        _guessed = x -> guessed(x);
        _showUser = x -> showUser(x);
    }

    @Override
    public void run()
    {
        _messages.subcribeTo("GameEnded", _end);
        _messages.subcribeTo("GameSetup", _start);
        _messages.subcribeTo("GuessedCorrectly", _guessed);
        _messages.subcribeTo("ShowUser", _showUser);
    }

    private void playGame(String result)
    {
        _gameOver = false;
        while(!_gameOver)
        {
            _media.print("Guess a letter: ");
            _messages.send("Guessed", _in.next().charAt(0) + "");
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

    private void showUser(String message)
    {
        _media.print(message);
    }
}
