package cactoos.convertible.character;

/**
 * Convertible character. It is a mathematical identity:
 * 1*1, 1+0, 1/1 and thus, it only transforms the 
 * character to a convertible type.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Convertible implements ConvertedCharacter {
	private final Character character;

	public Convertible(final Character character) {
		this.character = character;
	}

	@Override
	public Character character() {		
		return character;
	}
}