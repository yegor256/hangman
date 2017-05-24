package hangman.Message;

import java.io.PrintStream;

public class EmptyMessage implements MessageInterface {
    @Override
    public void send(PrintStream stream) {

    }

    @Override
    public String toString() {
        return "";
    }
}
