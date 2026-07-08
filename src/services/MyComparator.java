package services;

import java.util.Comparator;
import entities.Team;

public class MyComparator implements Comparator<Team> {
	@Override
	public int compare(Team t1, Team t2) {

		int comp = Integer.compare(t2.getPoints(), t1.getPoints());

		if (comp != 0) {
			return comp;
		}

		comp = Integer.compare(t2.getGoalDifference(), t1.getGoalDifference());

		if (comp != 0) {
			return comp;
		}

		comp = Integer.compare(t2.getGoalsScored(), t1.getGoalsScored());

		return comp;
	}
}