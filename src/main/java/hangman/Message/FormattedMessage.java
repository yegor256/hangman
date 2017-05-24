package hangman.Message;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Formatter;

public class FormattedMessage implements MessageInterface {

    private final MessageInterface message;
    private final Collection<Object> args;

    public FormattedMessage(final MessageInterface message, final Object... arguments) {
        this.message = message;
        this.args = Collections.unmodifiableCollection(Arrays.asList(arguments));
    }

    @Override
    public String toString() {
        final StringBuilder out = new StringBuilder(0);
        new Formatter(out).format(
            this.message.toString(), this.args.toArray(new Object[this.args.size()])
        );
        return out.toString();
    }

    @Override
    public void send(PrintStream stream) {
        stream.print(toString());
    }
}
