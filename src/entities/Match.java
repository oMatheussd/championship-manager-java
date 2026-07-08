package entities;

public class Match {

	private Team homeTeam;
	private Team awayTeam;
	private int homeGoals;
	private int awayGoals;

	public Match(Team homeTeam, Team awayTeam, int homeGoals, int awayGoals) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeGoals = homeGoals;
		this.awayGoals = awayGoals;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public int getHomeGoals() {
		return homeGoals;
	}

	public int getAwayGoals() {
		return awayGoals;
	}

	public void processResult() {
		homeTeam.addMatch();
		awayTeam.addMatch();
		
		homeTeam.addGoalsScored(homeGoals);
		homeTeam.addGoalsConceded(awayGoals);
		
		awayTeam.addGoalsScored(awayGoals);
		awayTeam.addGoalsConceded(homeGoals);
		
		if (homeGoals == awayGoals) {
			homeTeam.addDraw();
			awayTeam.addDraw();
		} else if (homeGoals > awayGoals) {
			homeTeam.addVictory();
			awayTeam.addDefeat();
		} else {
			awayTeam.addVictory();
			homeTeam.addDefeat();
		}
	}

	@Override
	public String toString() {
		return getHomeTeam().getTeamName() + " " + getHomeGoals() + " x " + getAwayGoals() + " " + getAwayTeam().getTeamName();
	}
	
	

}
