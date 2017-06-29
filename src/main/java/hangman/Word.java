package hangman;

public final class Word {

    private final String letters;
    private final int[] mask;

    public Word(final String letters) {
        this(letters, new int[letters.length()]);
    }

    public Word(final String letters, final int[] mask) {
        this.letters = letters;
        this.mask = mask;
    }

    public String maskedValue() throws Exception {
        String masked = new String();
        for (int i = 0; i < this.mask.length; i++) {
            masked += this.mask[i] == 0 ? "*" : this.letters.charAt(i);
        }
        return masked;
    }

    public String unmaskedValue() throws Exception {
        return this.letters;
    }

    public boolean opened() throws Exception {
        for (final int i : this.mask) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean visible(final char chr) throws Exception {
        final int[] chars = this.letters.codePoints().toArray();
        for (int i = 0; i < chars.length; i++) {
            if (chr == chars[i] && this.mask[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public void unhide(final int position) throws Exception {
        if (position < 0 || position > this.mask.length - 1) {
            throw new Exception("Out of bounds of the array");
        }
        this.mask[position] = 1;
    }

    public void unhide(final char chr) throws Exception {
        for (int i = 0; i < this.letters.codePoints().toArray().length; i++) {
            if (this.letters.charAt(i) == chr) {
                this.unhide(i);
            }
        }
    }

    public boolean contains(final char letter) {
        return this.letters.indexOf(letter) > -1;
    }
}
