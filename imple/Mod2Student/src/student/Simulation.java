package student;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;
import mod.robot.Robot;
import mod.server.Server;
import mod.server.app.AppContainer;
import mod.server.app.TaxiApp;
import mod.server.app.TaxiRequest;
import mod.server.app.interfaces.ITaxiApp;
import mod.server.hospital.Hospital;
import robotino.Position;
import student.robot.MyRobot;
import student.server.MyServer;

public class Simulation extends mod.Simulation
{
	public static Position POSITION_1 = new Position( 4.4f, 5.5f);
	public static Position POSITION_2 = new Position(-3.0f, 4.0f);
	public static Position POSITION_3 = new Position(-7.0f,-1.0f);
	public static Position POSITION_4 = new Position(-2.0f,-3.5f);
	public static Position POSITION_5 = new Position( 4.5f,-2.5f);
	
	public static void main(String[] args)
	{
		Simulation simulation = new Simulation();
		simulation.start();
	}

	@Override
	protected int numberOfRobots()
	{
		return 2;
	}

	@Override
	protected Robot constructRobot(String ip)
	{
		return new MyRobot(ip);
	}

	@Override
	protected Server constructServer(Hospital hospital, AppContainer apps)
	{
		return new MyServer(hospital, apps);
	}

	@Override
	protected Hospital constructHospital()
	{
		Long time = Calendar.getInstance().getTimeInMillis();
		
		Queue<Pair<Long,Position>> emergencies = new LinkedList<Pair<Long, Position>>();
		emergencies.add(new Pair<Long,Position>(time, POSITION_1));
		emergencies.add(new Pair<Long,Position>(time + 30000, POSITION_3));
		emergencies.add(new Pair<Long,Position>(time + 35000, POSITION_1));
		
		return new Hospital(emergencies);
	}

	@Override
	protected AppContainer constructApps()
	{
		Long time = Calendar.getInstance().getTimeInMillis();
		
		int numberOfApps = 4;
		
		ITaxiApp[] apps = new ITaxiApp[numberOfApps];
		
		TaxiRequest[] requests1 = 
			new TaxiRequest[]
			{
					new TaxiRequest(POSITION_1, POSITION_2, (long) 0),
					new TaxiRequest(POSITION_2, POSITION_3, (long) 0),
					new TaxiRequest(POSITION_3, POSITION_1, (long) 0)
			};
		long[] schedule1 = 
			new long[]
			{
				time + 5000,
				time + 30000,
				time + 60000
			};
		apps[0] = createAppWithScheduledRequests(requests1, schedule1);
		
		TaxiRequest[] requests2 = 
			new TaxiRequest[]
			{
				new TaxiRequest(POSITION_3, POSITION_4, (long) 0),
				new TaxiRequest(POSITION_4, POSITION_3, (long) 0)
			};
		long[] schedule2 = 
			new long[]
			{
				time,
				time + 45000,
			};
		apps[1] = createAppWithScheduledRequests(requests2, schedule2);
		
		TaxiRequest[] requests3 = new TaxiRequest[]{new TaxiRequest(POSITION_4, POSITION_1, (long) 0)};
		long[] schedule3 = new long[]{time};
		apps[2] = createAppWithScheduledRequests(requests3, schedule3);
		
		TaxiRequest[] requests4 = new TaxiRequest[]{new TaxiRequest(POSITION_1, POSITION_2, (long) 6000)};
		long[] schedule4 = new long[]{time};
			
		apps[3] = createAppWithScheduledRequests(requests4, schedule4);

		return new AppContainer(apps);
	}

	private TaxiApp createAppWithScheduledRequests(TaxiRequest[] requests, long[] schedule) 
	{
		Queue<Pair<Long,TaxiRequest>> requestList = new LinkedList<Pair<Long, TaxiRequest>>();
		for (int idx = 0; idx < requests.length; idx++) 
		{
			requestList.add(new Pair<Long, TaxiRequest>(schedule[idx], requests[idx]));	
		}
		return new TaxiApp(0, requestList);
	}

}
