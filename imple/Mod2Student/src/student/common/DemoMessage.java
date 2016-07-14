package student.common;

import mod.network.IMessage;

public class DemoMessage implements IMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DemoMessage(String str, int reciever) {
		this.str = str;
		this.recId = reciever;
	}
	public String str;
	int recId;
	int sendId;
	
	@Override
	public void setReceiverID(int id) {
		this.recId = id;
	}

	@Override
	public int getReceiverID() {
		return recId;
	}

	@Override
	public int getSenderID() {
		return sendId;
	}

	@Override
	public void setSenderID(int id) {
		sendId = id;
	}
	
}
