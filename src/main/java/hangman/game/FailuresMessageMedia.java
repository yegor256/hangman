package game;

import event.Message;

public interface FailuresMessageMedia extends Message {
	public FailuresMessageMedia withCurrent(String template);
	public FailuresMessageMedia withText(String text);
	public FailuresMessageMedia withMax(String template);	
}