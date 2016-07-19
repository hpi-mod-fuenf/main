package student.robot;

import java.beans.DesignMode;
import java.io.Console;

import com.sun.org.apache.xerces.internal.dom.DeferredElementNSImpl;

import mod.network.IMessage;
import mod.network.IMessageHandler;
import mod.robot.IRSensorDistance;
import mod.robot.Robot;
import mod.robot.interfaces.ArrivalHandler;
import robotino.Position;
import student.Simulation;
import student.common.DemoMessage;
import student.common.Destination;
import student.common.Task;

import java.util.concurrent.TimeUnit ;

public class MyRobot extends Robot implements IMessageHandler, ArrivalHandler
{
	public static final int SERVER_ID = 3;
	
	public MyRobot(String ip)
	{	
		super(ip);
		network.registerMessageHandler(this);
		//drive.driveToPosition(new Position(0, 0), 1, this);
	}

	private Task currentTask = null;
	private int taskPtr = 0;
	
	@Override
	public void run()
	{
		System.out.printf("Robot %s: Starting...\n", address());
		
		System.out.println("run : " + network.getMyID());
		
		//register at server
		DemoMessage msg = new DemoMessage("hallo I am " + network.getMyID(),network.getMyID());
		msg.setSenderID(network.getMyID());
		network.send(msg);
		drive.driveToPosition(new Position(0, 0), 0.5f, this);
		
		
		while(!Thread.currentThread().isInterrupted() && connected())
		{
			processEvents();
			//System.out.println("id" + network.getMyID());
			Simulation.pause(50);
		}
		
		System.out.printf("Robot %s: Terminating...\n", address());
	}

	private void continueTask(){
		if(currentTask.pos.size() <= taskPtr){
			//finished
			System.out.println("task finished");
		}
		else{
			Destination dest = currentTask.pos.get(taskPtr++);
			if(dest.speed == Destination.Speed.Fast){
				drive.driveToPosition(dest.position, 1, this);
			}
		}
	}
	
	private void driveAroundObstacle() {
		float s = 0.5f;				//Sicherheitsabstand
		IRSensorDistance[] distances = distanceSensor.getIRDistances();
		while (distances[0].distance() < s ||
			   distances[1].distance() < s ||
			   distances[2].distance() < s ||
			   distances[7].distance() < s ||
			   distances[8].distance() < s) {
			while(distances[2].distance() > distances[1].distance()) {
				drive.drive(0f, 0f, 5f);		//Bin mir nicht sicher, ob die drive Methode so richtig verwendet wird, er soll sich 5 grad nach rechts drehen
				distances = distanceSensor.getIRDistances();
			}
			while (distances[0].distance() < s ||
				   distances[1].distance() < s ||
				   distances[2].distance() < s ||
				   distances[7].distance() < s ||
				   distances[8].distance() < s) {
				drive.drive(0f, 0f, 5f);		//Bin mir nicht sicher, ob die drive Methode so richtig verwendet wird, er soll sich 5 grad nach rechts drehen
				distances = distanceSensor.getIRDistances();
			}
			float d = 0;						//speichert gefahrene Distanz
			while ((distances[0].distance() < s ||
					distances[1].distance() < s ||
					distances[2].distance() < s ||
					distances[7].distance() < s ||
					distances[8].distance() < s) &&
				   d < 1.5f) {
				drive.drive(0.1f, 0f, 0f);
				//Wie stoppe ich hier nach 1 Sekunde, d.h. 10cm wieder?
				distances = distanceSensor.getIRDistances();
				d += 0.1f;
			}
		}
	}
	
	@Override
	public void handleIncommingMessage(IMessage message) {
		System.out.println("");
		System.out.println("robot " + this.network.getMyID() + " got msg");
		if(message.getClass() == Task.class){
			currentTask = (Task) message;
			taskPtr = 0;
			continueTask();
		}
		else if(message.getClass() == DemoMessage.class){
			DemoMessage demoMsg = (DemoMessage) message;
			System.out.println(demoMsg.str);
		}
	}

	@Override
	public void arrived() {
		
	}

}
