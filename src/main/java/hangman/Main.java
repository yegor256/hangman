package hangman;

public class Main {
    public static void main(final String... args) {
        UserInput userInput = new UserInput();
        Secret secret = new Secret();

        new InfinityGame(
            new Hangman(
                    new Attempt(
                            userInput,
                        secret
                ),
                secret,
                5
            ),
            userInput
        ).play();
    }
}
