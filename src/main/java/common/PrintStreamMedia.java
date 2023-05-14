package common;

import java.io.OutputStream;
import java.io.PrintStream;

public final class PrintStreamMedia implements Media
{
    private final PrintStream _stream;

    public PrintStreamMedia(OutputStream out)
    {
        this(new PrintStream(out));
    }

    public PrintStreamMedia(PrintStream stream)
    {
        _stream = stream;
    }

    @Override
    public void print(String text)
    {
        _stream.print(text);
    }
}
