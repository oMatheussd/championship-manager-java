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

			Team homeTeam = null;

			for (Team t : teams) {
				if (homeTeamName.equals(t.getTeamName())) {
					homeTeam = t;
					break;
				}
			}

			System.out.print("Time visitante: ");
			String awayTeamName = sc.nextLine();

			Team awayTeam = null;

			for (Team t : teams) {
				if (awayTeamName.equals(t.getTeamName())) {
					awayTeam = t;
					break;
				}
			}

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
		
		for (Team t : teams) {
			System.out.println(t);
			System.out.println();
		}
		
		sc.close();
	}
}
