package hangman;

class Round {

    private final Game game;
    private final char inputLetter;
    private StringBuilder wordAfterRound;

    Round(Game game, char inputLetter) {
        this.game = game;
        this.inputLetter = inputLetter;
    }

    String getWordAfterRound() {
        if (wordAfterRound == null) {
            haveHit();
        }
        return wordAfterRound.toString();
    }

    boolean haveHit() {
        String word = game.getWinWord();
        wordAfterRound = new StringBuilder(game.getWord());
        boolean hit = false;
        for (int index = 0; index < word.length(); index++) {
            if ((word.charAt(index) == inputLetter) && ((wordAfterRound.charAt(index) != inputLetter))) {
                wordAfterRound.setCharAt(index, inputLetter);
                hit = true;
            }
        }
        return hit;
    }

}
