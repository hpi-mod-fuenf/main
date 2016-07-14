package student.server;

import mod.Simulation;
import mod.server.Server;
import mod.server.app.AppContainer;
import mod.server.hospital.Hospital;

public class MyServer extends Server
{
	public MyServer(Hospital hospital, AppContainer apps)
	{
		super(hospital, apps);
	}

	@Override
	public void run()
	{
		System.out.format("Server: Starting...");
		
		while(!Thread.currentThread().isInterrupted())
		{
			processEvents();
			
			//TODO: Add own implementation
			
			Simulation.pause(50);
		}
		
		System.out.format("Server: Terminating...");
	}

}
