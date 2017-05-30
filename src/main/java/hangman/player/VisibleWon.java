package player;

public final class VisibleWon implements WonView {

	@Override
	public void show() {		
		System.out.println("You won!\n");
	}
}