package generics;

public abstract class Player implements Comparable<Player>{
	
	private String name;
	
	public Player(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public int compareTo(Player player) {
		return this.name.compareTo(player.getName());
	}
}
