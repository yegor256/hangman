package cactoos.convertible.character;

/**
 * Lowercased character.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Lowercased implements ConvertedCharacter {
	private final Character character;

	public Lowercased(final Character character) {
		this.character = character;
	}

	@Override
	public Character character() {		
		return Character.toLowerCase(character);
	}
}