package generics;

public class Application {

	public static void main(String[] args) {
		
		Team<BaseballPlayer> braves = new Team<>("Braves");
		Team<BaseballPlayer> mets = new Team<>("Mets");
		Team<FootballPlayer> falcons = new Team<>("Falcons");
		Team<FootballPlayer> patriots = new Team<>("Patriots");
		
		BaseballPlayer bob = new BaseballPlayer("bob");
		BaseballPlayer joe = new BaseballPlayer("joe");
		
		FootballPlayer john = new FootballPlayer("John");
		FootballPlayer robert = new FootballPlayer("Robert");
		
		League<Team<BaseballPlayer>> baseballLeague = new League<>();
		League<Team<FootballPlayer>> footballLeague = new League<>();
		
		baseballLeague.addTeam(mets);
		baseballLeague.addTeam(braves);
		
		footballLeague.addTeam(patriots);
		footballLeague.addTeam(falcons);
		
		falcons.addPlayer(robert);
		falcons.addPlayer(john);
		
		falcons.printPlayers();
		
		baseballLeague.printTeams();
		
		braves.addPlayer(bob);
		braves.addPlayer(joe);
	}

}
