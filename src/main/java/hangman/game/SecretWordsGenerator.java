package hangman.game;

import java.util.Random;

class SecretWordsGenerator {

    private static final String[] SECRET_WORDS = {
            "simplicity", 
            "equality", 
            "grandmother",
            "neighborhood", 
            "relationship", 
            "mathematics",
            "university", 
            "explanation"
    };

    private final Random random;

	public SecretWordsGenerator() {
		random = new Random();
	}

	String getSecretWord() {
		int wordDbSize = SECRET_WORDS.length;
		String word = SECRET_WORDS[random.nextInt(wordDbSize)];

		return word;
	}
}
