package cactoos.convertible.character;

/**
 * Uppercased character.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Uppercased implements ConvertedCharacter {
	private final Character character;

	public Uppercased(final Character character) {
		this.character = character;
	}

	@Override
	public Character character() {		
		return Character.toUpperCase(character);
	}
}