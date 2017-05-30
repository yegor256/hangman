package word;

/**
 * Turning on the letter.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class LetterOn implements LetterOnAction {
	private final LetterState letter;
	private final WhereSymbolIs whereLetter;

	public LetterOn(final LetterState letter, final WhereSymbolIs whereLetter) {
		this.letter = letter;
		this.whereLetter = whereLetter;
	}

	@Override
	public LetterState letter() {		
		return 
			whereLetter.is(letter) 
			? letter.on() 
			: letter;
	}
}