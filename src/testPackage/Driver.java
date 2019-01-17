package testPackage;


public class Driver 
{
	
	public static void main(String[] args) 
	{
		try {
			Position pos1 = new Position(3, 2);
			Position pos2 = new Position(1, 6);
			
			Position.getPossiblePos(pos1, pos2);
		} catch (Exception e) {}
	}
}
