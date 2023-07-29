package hangman;

import java.util.Random;

class Secret {
    private static final String[] WORDS = {
            "simplicity", "equality", "grandmother",
            "neighborhood", "relationship", "mathematics",
            "university", "explanation"
    };

    private final boolean[] visible;
    private final String word;

    Secret() {
        this.word = WORDS[new Random().nextInt(WORDS.length)];
        this.visible = new boolean[word.length()];
    }

    String word() {
        return this.word;
    }

    boolean done() {
        for (int i = 0; i < this.word.length(); ++i) {
            if (!this.visible[i]) {
                return false;
            }
        }
        return true;
    }

    void state() {
        System.out.append("The word: ");
        for (int i = 0; i < this.word().length(); i++) {
            if (this.visible[i]) {
                System.out.print(this.word().charAt(i));
            } else {
                System.out.print("?");
            }
        }
        System.out.print("\n");
    }

    boolean isClosed(int i) {
        return !this.visible[i];
    }

    void open(int i) {
        this.visible[i] = true;
    }
}
