package robot;

import robotino.Position;

public class BatterySimulation extends student.Simulation
{

	public static void main(String[] args)
	{
		BatterySimulation simulation = new BatterySimulation();
		simulation.start();
		simulation.test();
	}
	
	@Override
	protected int numberOfRobots()
	{
		return 1;
	}
	
	public void test()
	{
		// After 10 Seconds the robot should be at the loading position.
		pause(10000);
		robotThreads[0].interrupt();
		serverThread.interrupt();
		pause(200);
		
		Position current = robots[0].northStar.position();
		Position target = robots[0].battery.getLoadingPosition();
		double distance = Math.sqrt(Math.pow(current.x() - target.x(), 2) + Math.pow(current.y() - target.y(), 2));
		if(distance < 0.2)
		{
			System.out.format("System: A Robot arrived at the loading Position.");
		}
		else
		{
			System.out.format("System: A Robot failed to arrived at the loading Position. Distance is %f", distance);
		}
		
		System.exit(0);
	}
}
