package hangman;

import common.Media;
import common.Messages;
import common.PrintStreamMedia;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game implements Runnable
{
    private final List<Runnable> _objects;
    private final WordList _words;
    private final Messages _messages;

    public static void main(String[] args)
    {
        new Game(System.in, System.out, 5).run();
    }

    public Game( InputStream in, OutputStream out, int maxMistakes)
    {
        this(new Messages(), new WordList(), new PrintStreamMedia(out), new Scanner(in), maxMistakes);
    }

    public Game(Messages messages, WordList words, Media media, Scanner in, int maxMistakes)
    {
        this(messages, words, new UserInterface(messages, media, in), new Secret(messages), new Gallows(messages, maxMistakes));
    }

    private Game(Messages messages, WordList words, Runnable... objects)
    {
        _objects = Arrays.asList(objects);
        _messages = messages;
        _words = words;
    }

    @Override
    public void run()
    {
        _objects.forEach(x -> x.run());
        _messages.send("GameStarted", _words.random());
    }
}
