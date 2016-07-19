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

public class MyRobot extends Robot
{
	
	public MyRobot(String ip)
	{	
		super(ip);

		//DEMO: Wir versuchen hier einfach mal mit allen robotern zu (0,0) zu fahren
		drive.driveToPosition(new Position(1, 1), 0.5f, new ArrivalHandler() {
			
			@Override
			public void arrived() {
				System.out.println("wann sind wir endlich daha? - Jetzt!");
			}
		});
	}

	
	@Override
	public void run()
	{
		//register at server

		
		
		while(!Thread.currentThread().isInterrupted() && connected())
		{
			processEvents();
			
			//hier können wir regelmäßig dinge ausführen
			
			//sinnvoll wäre also regelmäßig die sensoren zu checken , 
			//wenn ein hinderniss kommt daas zu umfahren und dann wieder 
			// das ursprüngliche Ziel anzusteuern.
			
			Simulation.pause(50);
		}
		
		System.out.printf("Robot %s: Terminating...\n", address());
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

}
