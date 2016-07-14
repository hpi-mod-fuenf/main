package student.server;

import java.util.Map;
import java.util.PriorityQueue;

import mod.Simulation;
import mod.network.IMessage;
import mod.network.IMessageHandler;
import mod.server.Server;
import mod.server.app.AppContainer;
import mod.server.hospital.Hospital;
import mod.server.hospital.interfaces.IHospitalInputHandler;
import robotino.Position;
import student.common.DemoMessage;
import student.common.Destination;
import student.common.Task;
import student.common.Destination.Speed;
import student.server.VirtualRobot.RobotState;

public class MyServer extends Server implements IHospitalInputHandler, IMessageHandler
{
	
	private PriorityQueue<Task> tasks;
	private Map<Integer,VirtualRobot> robs;
	
	public MyServer(Hospital hospital, AppContainer apps)
	{
		super(hospital, apps);
		hospital.setInputHandler(this);
		tasks = new PriorityQueue<Task>(10, new TaskComparator());
	}

	@Override
	public void run()
	{
		System.out.format("Server: Starting...");
		network.registerMessageHandler(this);
		
		while(!Thread.currentThread().isInterrupted())
		{
			processEvents();
			
			VirtualRobot freeRob;
			while(tasks.size() > 0){
				freeRob = findFreeRob();
				if(freeRob == null)
					break;
				//freeRob
			}
			
			Simulation.pause(50);
		}
		
		System.out.format("Server: Terminating...");
	}
	
	private VirtualRobot findFreeRob() {
		for(VirtualRobot rob : robs.values()){
			if(rob.state == RobotState.Free)
				return rob;
		}
		return null;
	}

	@Override
	public void getPatientAt(Position pos) {
		Task t = new Task();
		t.priority = Task.PRIORITY_HOSP;
		t.pos.add(new Destination(Speed.Fast,pos));
		t.pos.add(new Destination(Speed.Cautious,Hospital.HOSPITAL_POSITION));
		tasks.add(t);
	}

	@Override
	public void patientOnBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void patientArrived() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleIncommingMessage(IMessage message) {
		System.out.println("got message");
		if(message.getClass() == DemoMessage.class){
			DemoMessage demo = (DemoMessage) message;
			System.out.println(demo.str);
			if(!robs.containsKey(message.getSenderID())){
				robs.put(message.getSenderID(), new VirtualRobot(message.getSenderID()));
			}
		}
		else if(robs.containsKey(message.getSenderID())){
			robs.get(message.getSenderID()).handleIncommingMessage(message);
		}
	}

}
