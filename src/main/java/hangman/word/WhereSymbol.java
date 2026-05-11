package word;

import java.lang.Character;
import cactoos.comparable.character.InsensitiveEqual;

/**
 * Check if two letters have the same symbol.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class WhereSymbol implements WhereSymbolIs {
	private final Character symbol;

	public WhereSymbol(final Character symbol) {
		this.symbol = symbol;
	}

	@Override
	public boolean is(final LetterState letter) {		
		return new InsensitiveEqual(symbol, letter.symbol()).ok();
	}
}