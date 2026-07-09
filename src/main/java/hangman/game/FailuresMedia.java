package game;

import event.Message;

public interface FailuresMedia extends Message {
	public FailuresMedia withCurrent(String template);
	public FailuresMedia withText(String text);
	public FailuresMedia withMax(String template);	
}