package OOP_hangman;

class Result {
    private final Mistakes mistakes;
    private final Riddle riddle;

    Result(Mistakes mistakes, Riddle riddle) {
        this.mistakes = mistakes;
        this.riddle = riddle;
    }

    void say() {
        while (!this.riddle.isDone()) {
            this.mistakes.currentMistakeCheck();
            if (this.mistakes.matches()) {
                System.out.append("\n\n");
                System.out.print("You lost.\n");
                return;
            }
        }
        System.out.append("\n\n");
        System.out.print("You won!\n");
    }
}
