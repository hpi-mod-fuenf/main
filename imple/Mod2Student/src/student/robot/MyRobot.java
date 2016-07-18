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
	
	private void driveAroundObstacle() throws InterruptedException{
		/*IRSensorDistance nearestDistance = distanceSensor.getNearestIRDistance();
		while (nearestDistance.distance() < 1 && (nearestDistance.positionDegree() <= 90 || nearestDistance.positionDegree() >= 270)) {
			//drehe nach rechts
			TimeUnit.SECONDS.sleep(1);
			nearestDistance = distanceSensor.getNearestIRDistance();
		}
		while () {
			
		}*/
		IRSensorDistance[] distances = distanceSensor.getIRDistances();
		int x = 0;
		int y = 0;
		for (int i = 0; i < 9; i++) {					//gewichteten Vektor berechnen (richtig?)
			x += distances[i].distance() * Math.cos(Math.toRadians((double)(i*40)));
			y += distances[i].distance() * Math.sin(Math.toRadians((double)(i*40)));
		}
		double turn = 1*x/(Math.sqrt((double)(x*x+y*y)));	//Winkel zwischen ursprungsvektor und gewichtetem berechnen (richtig?)
		turn = Math.acos(turn) * (180/Math.PI);
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
