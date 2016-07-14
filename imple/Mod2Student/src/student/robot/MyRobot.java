package student.robot;

import mod.robot.Robot;
import student.Simulation;
import student.common.DemoMessage;

public class MyRobot extends Robot
{
	public MyRobot(String ip)
	{
		super(ip);
	}

	@Override
	public void run()
	{
		System.out.printf("Robot %s: Starting...\n", address());
		
		while(!Thread.currentThread().isInterrupted() && connected())
		{
			processEvents();
			network.send(new DemoMessage("hallo",network.getServerID()));
			
			Simulation.pause(50);
		}
		
		System.out.printf("Robot %s: Terminating...\n", address());
	}

}
