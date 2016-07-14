package student.common;

import robotino.Position;

public class Destination {
	public Destination(Speed speed, Position position){
		this.speed = speed;
		this.position = position;
		
	}
	public enum Speed{
		Cautious, Fast
	}
	public Position position;
	public Speed speed;
}
