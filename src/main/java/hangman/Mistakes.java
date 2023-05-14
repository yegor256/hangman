package hangman;

class Mistakes {
    private final Attempt attempt;
    private final Secret secret;
    private final int max;

    public Mistakes(Attempt attempt, Secret secret, int max) {
        this.attempt = attempt;
        this.secret = secret;
        this.max = max;
    }

    boolean matches() {
        int mistakes = 0;

        while (mistakes < this.max) {
            if (this.attempt.check()) {
                System.out.println("Hit!");
            } else {
                mistakes++;
                System.out.printf("Missed, mistake #%d out of %d\n", mistakes + 1, this.max);
            }

            this.secret.state();

            if (this.secret.done()) {
                return true;
            }
        }

        return false;
    }
}
