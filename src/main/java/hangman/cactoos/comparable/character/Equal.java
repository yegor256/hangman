package cactoos.comparable.character;

import java.lang.Character;
import cactoos.convertible.character.ConvertedCharacter;
import cactoos.convertible.character.Convertible;

/**
 * Character equality.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Equal implements CharacterEquality {
	private final ConvertedCharacter a;
	private final ConvertedCharacter b;

	public Equal(final Character a, final Character b) {
		this(new Convertible(a), new Convertible(b));
	}	

	public Equal(final ConvertedCharacter a, final ConvertedCharacter b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public boolean ok() {		
		return a.character().equals(b.character());
	}
}