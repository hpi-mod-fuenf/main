package student.server;

import java.util.Comparator;
import java.util.PriorityQueue;

import robotino.Position;
import student.common.Task;
import mod.Simulation;
import mod.network.IMessage;
import mod.network.IMessageHandler;
import mod.server.Server;
import mod.server.app.AppContainer;
import mod.server.hospital.Hospital;
import mod.server.hospital.interfaces.IHospitalInputHandler;

public class MyServer extends Server implements IHospitalInputHandler, IMessageHandler
{
	
	private PriorityQueue<Task> tasks;
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
		
		while(!Thread.currentThread().isInterrupted())
		{
			processEvents();
			
			//TODO: Add own implementation
			network.registerMessageHandler(this);
			
			Simulation.pause(50);
		}
		
		System.out.format("Server: Terminating...");
	}

	@Override
	public void getPatientAt(Position pos) {
		Task t = new Task();
		t.priority = Task.PRIORITY_HOSP;
		t.pos.add(pos);
		t.pos.add(Hospital.HOSPITAL_POSITION);
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
	}

}
