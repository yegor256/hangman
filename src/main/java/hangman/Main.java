package hangman;

import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    private final InputStream input;
    private final OutputStream output;
    private final int max;

    public Main(InputStream input, OutputStream output, int max) {
        this.input = input;
        this.output = output;
        this.max = max;
    }

    public static void main(String[] args) {
        Main main = new Main(System.in, System.out, 5);
        main.exec();
    }

    public void exec() {
        Farewell farewell = new Farewell(new Attempts(new InputCheck(new Word(), new Guess(input)), max, output), output);
        farewell.start();
    }
}
