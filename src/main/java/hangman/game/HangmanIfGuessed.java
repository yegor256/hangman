package game;

import event.Dispatching;
import event.Event;
import event.IsUncaught;
import word.WereLettersOn;

/**
 * Guessed dispatching events.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class HangmanIfGuessed implements Dispatching {
	private final WereLettersOn wereLetters;
	private final Dispatching source;

	public HangmanIfGuessed(final WereLettersOn wereLetters, final Dispatching source) {
		this.wereLetters = wereLetters;
		this.source = source;
	}

	@Override
	public Event event() {
		Event sourceEvent = source.event();	
		return 			
			new IsUncaught(sourceEvent).matched() && wereLetters.on()
			? new HangmanGuessed()	
			: sourceEvent
			;		
	}
}