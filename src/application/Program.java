package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Match;
import entities.Team;
import services.MyComparator;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Team> teams = new ArrayList<>();
		List<Match> matches = new ArrayList<>();

		System.out.print("Quantos times participarão? ");
		int numberOfTeams = sc.nextInt();

		System.out.println();
		System.out.println("Informe o nome dos times:");

		sc.nextLine();

		for (int i = 0; i < numberOfTeams; i++) {
			System.out.print("Time #" + (i + 1) + ": ");
			String teamName = sc.nextLine();
			teams.add(new Team(teamName));
		}

		System.out.println();
		System.out.print("Quantas partidas serão disputadas? ");
		int numberOfMatches = sc.nextInt();
		sc.nextLine();

		System.out.println();
		for (int i = 0; i < numberOfMatches; i++) {
			System.out.println("Partida #" + (i + 1));

			System.out.print("Time da casa: ");

			String homeTeamName = sc.nextLine();

			Team homeTeam = findTeam(teams, homeTeamName);

			System.out.print("Time visitante: ");
			String awayTeamName = sc.nextLine();

			Team awayTeam = findTeam(teams, awayTeamName);

			System.out.print("Gols do mandante: ");
			int homeGoals = sc.nextInt();
			System.out.print("Gols do visitante: ");
			int awayGoals = sc.nextInt();

			sc.nextLine();

			Match match = new Match(homeTeam, awayTeam, homeGoals, awayGoals);

			match.processResult();

			matches.add(match);

			System.out.println();
		}

		teams.sort(new MyComparator());
		Team champion = teams.get(0);
		
				
		System.out.println("CAMPEÃO: " + champion.getTeamName());
		
		System.out.println();
		System.out.println("RESULTADO DAS PARTIDAS");
		System.out.println();
		
		for (Match m : matches) {
			System.out.println(m);
		}
		
		System.out.println();
		System.out.println("CLASSIFICAÇÃO");
		System.out.println();

		for (Team t : teams) {
			System.out.println(t);
			System.out.println();
		}

		sc.close();
	}

	public static Team findTeam(List<Team> teams, String teamName) {

		for (Team t : teams) {
			if (teamName.equals(t.getTeamName())) {
				return t;
			}
		}
		return null;
	}
}
