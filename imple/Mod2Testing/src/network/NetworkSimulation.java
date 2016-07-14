package network;

import mod.Simulation;
import mod.robot.Robot;
import mod.server.Server;
import mod.server.app.AppContainer;
import mod.server.hospital.Hospital;

public class NetworkSimulation extends Simulation
{

	public static void main(String[] args)
	{
		NetworkSimulation simulation = new NetworkSimulation();
		simulation.start();
	}
	
	@Override
	protected int numberOfRobots()
	{
		return 1;
	}

	@Override
	protected Robot constructRobot(String ip)
	{
		return new NetworkRobot(ip);
	}

	@Override
	protected Server constructServer(Hospital hospital, AppContainer apps)
	{
		return new NetworkServer(hospital, apps);
	}

}
