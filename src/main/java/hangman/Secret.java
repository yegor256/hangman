package hangman;

import java.util.Random;

public class Secret {
    private static final String[] WORDS = {
            "simplicity", "equality", "grandmother",
            "neighborhood", "relationship", "mathematics",
            "university", "explanation"
    };

    String word() {
        return WORDS[new Random().nextInt(WORDS.length)];
    }
}
