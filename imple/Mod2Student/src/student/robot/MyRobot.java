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

/*
 * 
 * # A fatal error has been detected by the Java Runtime Environment:
#
#  EXCEPTION_ACCESS_VIOLATION (0xc0000005) at pc=0x551d3460, pid=2388, tid=0x00000a34
#
# JRE version: Java(TM) SE Runtime Environment (8.0_92-b14) (build 1.8.0_92-b14)
# Java VM: Java HotSpot(TM) Client VM (25.92-b14 mixed mode windows-x86 )
# Problematic frame:
# C  [RobotinoExtension.dll+0x13460]
#
# Failed to write core dump. Minidumps are not enabled by default on client versions of Windows
#
# An error report file with more information is saved as:
# C:\Users\Dominik\Documents\GitHub\main\imple\Mod2Student\hs_err_pid2388.log
#
# If you would like to submit a bug report, please visit:
#   http://bugreport.java.com/bugreport/crash.jsp
# The crash happened outside the Java Virtual Machine in native code.
# See problematic frame for where to report the bug.
#
 */


public class MyRobot extends Robot
{

	public Position goal = new Position(1, 1);		//Hier muss immer das aktuelle Ziel rein gespeichert werden
	public boolean driving = true;					//Muss auf true gesetzt werden, wenn driveToPosition(...) aufgerufen wird
	public float s = 0.5f;							//Sicherheitsabstand
	
	public MyRobot(String ip)
	{	
		super(ip);

		//DEMO: Wir versuchen hier einfach mal mit allen robotern zu (0,0) zu fahren
		drive.driveToPosition(goal, 0.5f, new ArrivalHandler() {
			
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
			
			IRSensorDistance[] sensorResults = distanceSensor.getIRDistances();
			while (sensorResults[0].distance() < s ||
				   sensorResults[1].distance() < s ||
				   sensorResults[2].distance() < s ||
				   sensorResults[7].distance() < s ||
				   sensorResults[8].distance() < s)
			{
				drive.drive(0, 0, 0);
				driving = false;
				driveAroundObstacle();
			}
			if (!driving)
			{
				driving = true;
				drive.driveToPosition(goal, 0.5f, new ArrivalHandler() {
			
				@Override
				public void arrived() {
					System.out.println("wann sind wir endlich daha? - Jetzt!");
				}
			});
			}
			
			Simulation.pause(50);
		}
		
		System.out.printf("Robot %s: Terminating...\n", address());
	}

	
	private void driveAroundObstacle() {
		IRSensorDistance[] distances = distanceSensor.getIRDistances();
		while (distances[0].distance() < s ||
			   distances[1].distance() < s ||
			   distances[2].distance() < s ||
			   distances[7].distance() < s ||
			   distances[8].distance() < s) {
			while(distances[2].distance() > distances[1].distance()) {
				drive.drive(0f, 0f, 0.5f);		//Bin mir nicht sicher, ob die drive Methode so richtig verwendet wird, er soll sich 5 grad nach rechts drehen
				distances = distanceSensor.getIRDistances();
			}
			while (distances[0].distance() < s ||
				   distances[1].distance() < s ||
				   distances[2].distance() < s ||
				   distances[7].distance() < s ||
				   distances[8].distance() < s) {
				drive.drive(0f, 0f, 0.5f);		//Bin mir nicht sicher, ob die drive Methode so richtig verwendet wird, er soll sich 5 grad nach rechts drehen
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
