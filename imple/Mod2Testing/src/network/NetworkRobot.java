package network;

import mod.network.IMessage;
import mod.network.IMessageHandler;
import mod.robot.Robot;
import student.Simulation;

public class NetworkRobot extends Robot implements IMessageHandler
{

	public NetworkRobot(String ip)
	{
		super(ip);
	}

	@Override
	public void run()
	{
		while(!Thread.currentThread().isInterrupted() && connected())
		{
			processEvents();
			Simulation.pause(50);
		}
	}

	@Override
	public void handleIncommingMessage(IMessage message)
	{
		
	}

}
