package student.common;

import java.util.LinkedList;
import java.util.List;

import mod.network.IMessage;
import robotino.Position;

public class Task implements IMessage{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Task(){
		pos = new LinkedList<Position>();
	}
	
	public static final int PRIORITY_HOSP = 2;
	public static final int PRIORITY_TAXI = 1;

	public int priority;
	public List<Position> pos;
	@Override
	public void setReceiverID(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getReceiverID() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getSenderID() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setSenderID(int id) {
		// TODO Auto-generated method stub
		
	}
}
