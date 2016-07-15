package student.common;

import mod.network.IMessage;

public class GenericMessage implements IMessage{
	public GenericMessage() {
		
	}
	
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
