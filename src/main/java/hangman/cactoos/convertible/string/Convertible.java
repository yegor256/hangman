package cactoos.convertible.string;

/**
 * Convertible string. It is a mathematical identity:
 * 1*1, 1+0, 1/1 and thus, it only transforms the 
 * string to a convertible type.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Convertible implements ConvertedString {
	private final String string;

	public Convertible(final String string) {
		this.string = string;
	}

	@Override
	public String string() {		
		return string;
	}
}