package entities;

public class Team {

	private String teamName;
	private int points;
	private int matches;
	private int victories;
	private int defeats;
	private int draws;
	private int goalsScored;
	private int goalsConceded;

	public Team(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getPoints() {
		return points;
	}

	public int getMatches() {
		return matches;
	}

	public int getVictories() {
		return victories;
	}

	public int getDefeats() {
		return defeats;
	}

	public int getDraws() {
		return draws;
	}

	public int getGoalsScored() {
		return goalsScored;
	}

	public int getGoalsConceded() {
		return goalsConceded;
	}
	
	public void addMatch() {
		matches++;
	}
	
	public void addVictory() {
		victories++;
		points += 3;
	}
	
	public void addDraw(){
		draws++;
		points += 1;
	}

	public void addDefeat(){
		defeats++;
	}	
	
	public void addGoalsScored(int goals) {
		goalsScored += goals;
	}
	
	public void addGoalsConceded(int goals) {
		goalsConceded += goals;
	}
	
	public int goalDifference() {
		return goalsScored - goalsConceded;
	}

	@Override
	public String toString() {
		return teamName 
				+ "\n"
				+ "Pontos: " + points 
				+ "\n"
				+ "Jogos: " + matches 
				+ "\n"
				+ "Vitorias: " + victories
				+ "\n"
				+ "Empates: " + draws
				+ "\n"
				+ "Derrotas: " + defeats
				+ "\n"
				+ "GP: " + goalsScored
				+ "\n"
				+ "GC: " + goalsConceded
				+ "\n"
				+ "SG: " + goalDifference(); 
	}

}
