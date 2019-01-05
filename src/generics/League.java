package generics;

import java.util.TreeSet;

public class League<T extends Team<?>> {
	
	private TreeSet<T> teams = new TreeSet<T>();
	
	
	public boolean addTeam(T team)
	{
		if(this.teams.contains(team))
		{
			return false;
		}
		
		this.teams.add(team);
		return true;
	}
	
	public void printTeams()
	{
		for(T team : teams)
		{
			System.out.println(team.getName());
		}
	}
}
