package network;

import mod.Simulation;
import mod.network.IMessage;
import mod.network.IMessageHandler;
import mod.server.Server;
import mod.server.app.AppContainer;
import mod.server.hospital.Hospital;

public class NetworkServer extends Server implements IMessageHandler
{

	public NetworkServer(Hospital hospital, AppContainer container)
	{
		super(hospital, container);
		network.registerMessageHandler(this);
	}

	@Override
	public void run()
	{
		System.out.format("Server: Starting...");
		
		while(!Thread.currentThread().isInterrupted())
		{
			network.processEvents();
			Simulation.pause(50);
		}
		
		System.out.format("Server: Terminating...");
	}

	@Override
	public void handleIncommingMessage(IMessage message)
	{
		PingMessage msg = (PingMessage)message;
		if(msg.isOrigin())
		{
			System.out.format("Server: Received a ping message from Robot %d.", msg.getSenderID());
			IMessage out = new PingMessage(false);
			out.setReceiverID(msg.getSenderID());
			network.send(out);
		}else
		{
			System.out.format("Server: Received a pong message from Robot %d.", msg.getSenderID());
		}
	}

}
