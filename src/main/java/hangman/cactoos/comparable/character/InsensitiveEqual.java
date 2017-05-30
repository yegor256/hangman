package cactoos.comparable.character;

import java.lang.Character;
import cactoos.convertible.character.Lowercased;

/**
 * Character equality.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class InsensitiveEqual implements CharacterEquality {
	private final Character a;
	private final Character b;

	public InsensitiveEqual(final Character a, final Character b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public boolean ok() {		
		return new Equal(new Lowercased(a), new Lowercased(b)).ok();
	}
}