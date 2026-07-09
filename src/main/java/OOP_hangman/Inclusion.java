package OOP_hangman;

class Inclusion {
    private final Riddle riddle;
    private final Guess guess;


    Inclusion(Riddle riddle, Guess guess) {
        this.riddle = riddle;
        this.guess = guess;
    }

    boolean isContained() {
        char ch = guess.letter();
        boolean hit = false;
        for (int i = 0; i < this.riddle.word().length(); ++i) {
            if (this.riddle.word().charAt(i) == ch && !this.riddle.visibleLetters[i]) {
                this.riddle.visibleLetters[i] = true;
                hit = true;
            }
        }
        return hit;
    }

    void showTheState() {
        this.riddle.showTheState();
    }
}
