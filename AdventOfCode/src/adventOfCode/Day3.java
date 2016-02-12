package adventOfCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3 {

	public int housesVisited(String directions) {
		List<String> visited = new ArrayList<String>();		
		visited.addAll(visit(directions));
		return countDifferent(visited);
	}

	private int countDifferent(List<String> visited) {
		Set<String> noDups = new HashSet<String>();
		noDups.addAll(visited);
		int differentHouses =  noDups.size();
		return differentHouses;
	}

	private Collection<String> visit(String directions) {
		List<String> visited = new ArrayList<String>();
		int actualH = 0;
		int actualW = 0;
		visited.add(actualH+","+actualW);
		for(int i = 0; i<directions.length();i++){
			switch (directions.charAt(i)) {
			case '^':
				actualH++;
				break;
			case 'v':
				actualH--;
				break;
			case '>':
				actualW++;
				break;
			case '<':
				actualW--;
				break;
			}
			visited.add(actualH+","+actualW);
		}
		return visited;
	}

	public int housesVisitedWithRobot(String directions) {
		StringBuilder santas = new StringBuilder(),robots = new StringBuilder();
		for(int i = 0; i<directions.length();i++){
			if( (i & 1) == 0)
				santas.append(directions.charAt(i));
			else
				robots.append(directions.charAt(i));
		}
		List<String> visited = new ArrayList<String>();		
		visited.addAll(visit(santas.toString()));
		visited.addAll(visit(robots.toString()));
		return countDifferent(visited);
		
	}
}

