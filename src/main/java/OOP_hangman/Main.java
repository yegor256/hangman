package OOP_hangman;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] WORDS = {
                "simplicity", "equality", "grandmother",
                "neighborhood", "relationship", "mathematics",
                "university", "explanation"
        };
        Riddle riddle = new Riddle(WORDS[new Random().nextInt(WORDS.length)]);
        new Result(
                new Mistakes(5,
                        new Inclusion(riddle,
                                new Guess())),
                riddle).say();
    }
}
