package hangman;

import java.util.Random;

public class WordExamples {
    private static final String[] WORDS = {
            "simplicity", "equality", "grandmother",
            "neighborhood", "relationship", "mathematics",
            "university", "explanation"
    };

    String chooseRandomWord(){
        return WORDS[new Random().nextInt(WORDS.length)];
    }
}
