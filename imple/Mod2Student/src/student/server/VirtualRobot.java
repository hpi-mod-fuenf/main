package student.server;

import student.common.Task;
import mod.network.IMessage;
import mod.network.IMessageHandler;
import mod.server.NetworkAccess;

public class VirtualRobot implements IMessageHandler{
	private NetworkAccess network;
	public VirtualRobot(int id,NetworkAccess network) {
		this.id = id;
		this.network = network;
	}
	public int id;
	
	public enum RobotState {
	    Free, Busy 
	}
	
	public RobotState state = RobotState.Free;

	@Override
	public void handleIncommingMessage(IMessage message) {
		
	}
	
	public void assignTask(Task t){
		state = RobotState.Busy;
		t.setSenderID(network.getMyID());
		t.setReceiverID(id);
		network.send(t);
	}

	
}
