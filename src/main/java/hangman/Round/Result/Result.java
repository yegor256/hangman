package hangman.Round.Result;

import hangman.Puzzle.PuzzleInterface;

public final class Result implements ResultInterface {

    private final boolean next;
    private final PuzzleInterface puzzle;

    public Result(PuzzleInterface puzzle, boolean next) {
        this.next = next;
        this.puzzle = puzzle;
    }

    @Override
    public PuzzleInterface puzzle() {
        return puzzle;
    }

    @Override
    public boolean next() {
        return next;
    }

}
