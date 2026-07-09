package OOP_hangman;


class Riddle {
    private final String word;
    boolean[] visibleLetters;

    Riddle(String word) {
        this.word = word;
        this.visibleLetters = new boolean[word.length()];
    }

    String word() {
        return this.word;
    }

    boolean isDone() {
        boolean isDone = true;
        for (int i = 0; i < this.word.length(); ++i) {
            if (!this.visibleLetters[i]) {
                isDone = false;
            }
        }
        return isDone;
    }

    void showTheState() {
        System.out.append("The word: ");
        for (int i = 0; i < this.word().length(); ++i) {
            if (this.visibleLetters[i]) {
                System.out.print(this.word().charAt(i));
            } else {
                System.out.print("?");
            }
        }
        System.out.print("\n");
    }
}
