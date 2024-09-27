package OOP_hangman;


class Mistakes {
    private final int max;
    private final Inclusion inclusion;
    private int currentMistakes;

    Mistakes(int max, Inclusion inclusion) {
        this.max = max;
        this.inclusion = inclusion;
        this.currentMistakes = 0;
    }

    void currentMistakeCheck() {
        if (this.currentMistakes < this.max) {
            if (!this.inclusion.isContained()) {
                ++currentMistakes;
                System.out.printf(
                        "Missed, mistake #%d out of %d\n",
                        currentMistakes, this.max
                );
            } else {
                System.out.print("Hit!\n");
            }
            this.inclusion.showTheState();
        }
    }

    boolean matches() {
        return this.currentMistakes == this.max;
    }
}
