package hangman;

public class InfinityGame {
    private final Playable game;
    private final UserInput userInput;

    public InfinityGame(Playable game, UserInput userInput) {
        this.game = game;
        this.userInput = userInput;
    }

    public void play() {
        while (true) {
            if (this.game.play()) {
                System.out.println("You won!\n");
            } else {
                System.out.println("You lost.\n");
            }

            System.out.println("Do you want to play one more time (y/n):\n");

            char chr = this.userInput.letter();
            if (chr == 'n') {
                break;
            }
        }
    }
}
