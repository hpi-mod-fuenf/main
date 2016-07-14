package student.common;

import java.util.LinkedList;
import java.util.List;

import mod.network.IMessage;

public class Task implements IMessage{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Task(){
		pos = new LinkedList<Destination>();
	}
	
	public static final int PRIORITY_HOSP = 2;
	public static final int PRIORITY_TAXI = 1;

	public int priority;
	public List<Destination> pos;
	
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
