package generics;

import java.util.TreeSet;

public class Team<T extends Player> implements Comparable<Team<T>> {
	
	private String name;
	private TreeSet<T> players = new TreeSet<>();
	
	
	public Team(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public boolean addPlayer(T player)
	{
		if(players.contains(player))
		{
			return false;
		}
		
		players.add(player);
		return true;
	}
	
	public void printPlayers()
	{
		for(T player : players)
		{
			System.out.println(player.getName());
		}
	}
	
	@Override
	public int compareTo(Team<T> team) {
		return this.name.compareTo(team.getName());
	}
}
