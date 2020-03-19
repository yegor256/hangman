package hangman;

public class Main {
    public static void main(String[] args) {
        Farewell farewell = new Farewell(new Attempts(new InputCheck(new Word()), 5));
        farewell.start();
    }
}
