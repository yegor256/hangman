package math;

import java.util.Random;

/**
 * Selecting a new random string from an array of strings.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class JRandomString implements RandomString {
	private final String[] strings;

	public JRandomString(final String[] strings) {
		this.strings = strings;
	}

	@Override
	public String next() {
		return strings[new Random().nextInt(strings.length)];		
	}
}