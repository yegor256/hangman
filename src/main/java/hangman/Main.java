package hangman;

public class Main {
    public static void main(final String... args) {
        Secret secret = new Secret();
        new Hangman(
                new Mistakes(
                        new Attempt(
                                new Guess(),
                                secret
                        ),
                        secret,
                        5
                )
        ).play();
    }
}
