package network;

import mod.network.IMessage;

public class PingMessage implements IMessage
{
	private static final long serialVersionUID = 1L;
	int sender;
	int receiver;
	boolean origin;

	public PingMessage(boolean origin)
	{
		this.origin = origin;
	}
	
	public boolean isOrigin()
	{
		return origin;
	}

	public void setOrigin(boolean origin)
	{
		this.origin = origin;
	}
	
	@Override
	public void setReceiverID(int id)
	{
		receiver = id;
	}

	@Override
	public int getReceiverID()
	{
		return receiver;
	}

	@Override
	public int getSenderID()
	{
		return sender;
	}

	@Override
	public void setSenderID(int id)
	{
		sender = id;
	}

}
