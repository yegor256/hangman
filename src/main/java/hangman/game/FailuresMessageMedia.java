package game;

import event.Message;

interface FailuresMessageMedia extends Message {
	public Message withCurrent(String template);
	public Message withText(String text);
	public Message withMax(String template);	
}