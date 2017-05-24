package hangman.Message;

import java.io.PrintStream;

public class Message implements MessageInterface {
    private final String message;
    private final MessageInterface next;

    public Message(String message) {
        this(message, new EmptyMessage());
    }

    public Message(String message, MessageInterface next) {
        this.message = message;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.message + this.next.toString();
    }

    @Override
    public void send(PrintStream stream) {
        stream.print(this.message);
        this.next.send(stream);
    }
}
