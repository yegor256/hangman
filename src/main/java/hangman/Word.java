package hangman;

public final class Word implements AbstractWord {

    private final String original;
    private final Character symbol;
    private final boolean[] mask;

    public Word(final String original) {
        this(original, '*');
    }

    public Word(final String original, final Character symbol) {
        this(original, symbol, new boolean[original.length()]);
    }

    public Word(final String original, final Character symbol, final boolean[] mask) {
        this.original = original;
        this.symbol = symbol;
        this.mask = mask;
    }

    public String original() {
        return this.original;
    }

    public Character symbol() {
        return this.symbol;
    }

    public String word() {
        final StringBuilder word = new StringBuilder("");
        for (int i = 0, mask1Length = this.mask.length; i < mask1Length; i++) {
            final boolean opened = this.mask[i];
            word.append(opened ? this.original.charAt(i) : this.symbol);
        }
        return word.toString();
    }

    public boolean contains(Character character) throws Exception {
        return this.original.indexOf(character) != -1;
    }

    public void open(final Character character) throws Exception {
        for (int i = 0; i < this.mask.length; i++) {
            if (!this.mask[i] && this.original.charAt(i) == character) {
                this.mask[i] = true;
            }
        }
    }

    @Override
    public boolean guessed() throws Exception {
        for (final boolean opened : this.mask) {
            if (!opened) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean opened(Character character) {
        for (int i = 0; i < this.mask.length; i++) {
            if (!this.mask[i] && this.original.charAt(i) == character) {
                return false;
            }
        }
        return true;
    }
}
