package student.robot;

import mod.network.IMessage;
import mod.network.IMessageHandler;
import mod.robot.Robot;
import mod.robot.interfaces.ArrivalHandler;
import student.Simulation;
import student.common.DemoMessage;
import student.common.Destination;
import student.common.Task;

public class MyRobot extends Robot implements IMessageHandler, ArrivalHandler
{
	public MyRobot(String ip)
	{
		super(ip);
	}

	private Task currentTask = null;
	private int taskPtr = 0;
	
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
		
		network.registerMessageHandler(this);
		
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
	
	@Override
	public void handleIncommingMessage(IMessage message) {
		System.out.println("client got msg");
		
		if(message.getClass() == Task.class){
			currentTask = (Task) message;
			taskPtr = 0;
			continueTask();
		}
	}

	@Override
	public void arrived() {
		
	}

}
