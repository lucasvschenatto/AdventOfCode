package adventOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import adventOfCode.submit.Challenge;

public class Day9 implements Challenge{
	@Override
	public String part1(String input) {
		int result = shortestRoute(input);
		return String.valueOf(result);
	}
	@Override
	public String part2(String input) {
		// TODO Auto-generated method stub
		return null;
	}
	public int shortestRoute(String input){
		List<String> cities = readCities(input);
		List<String> routes = new ArrayList<String>();
		mountRoutes(cities, new ArrayList<String>(), routes);
		List<Distance> distances = readDistances(input);
		List<Integer> routeDistances = routeDistancesFor(routes,distances);
		return findShortest(routeDistances);
	}
	private int findShortest(List<Integer> routeDistances) {
		Integer shortest = Integer.MAX_VALUE;
		for (Integer current : routeDistances) {
			if(current < shortest)
				shortest = current;
		}
		return shortest.intValue();
	}
	private List<Integer> routeDistancesFor(List<String> routes, List<Distance> distances) {
		List<Integer> routeDistances = new ArrayList<Integer>();
		for (String route : routes) {
			int current = 0;
			String[] cities = route.split(" ");
			for(int i = 0; i<(cities.length-1);i++){
				for (Distance distance : distances) {
					if(distance.cityA.equals(cities[i]) || distance.cityB.equals(cities[i]) )
						if(distance.cityA.equals(cities[i+1])
								|| distance.cityB.equals(cities[i+1]) ){
							current = current + distance.distance;
							break;
						}
				}
			}
			routeDistances.add(Integer.valueOf(current));
		}
		return routeDistances;
	}
	private void mountRoutes(List<String> citiesToRoute,List<String> citiesRouted, List<String> routes) {
		if(citiesToRoute.size()>0){
			for (String city : citiesToRoute) {
				List<String> remaining = new ArrayList<String>(citiesToRoute);
				remaining.remove(city);
				List<String> used = new ArrayList<String>(citiesRouted);
				used.add(city);
				mountRoutes(remaining, used, routes);
			}
		}
			else{
				StringBuilder route = new StringBuilder();
				for (String city : citiesRouted)
					route.append(city + " ");
				routes.add(route.toString().trim());
		}
	}
	public List<Distance> readDistances(String distancesString){
		List<Distance> distances = new ArrayList<Distance>();
		List<String> sDistances = Arrays.asList(distancesString.split("\n"));
		for (String wire : sDistances) {
			String[] splitA = wire.split(" to ");
			String[] splitB = splitA[1].split(" = ");
			distances.add(new Distance(splitA[0], splitB[0], Integer.valueOf(splitB[1])));
		}
		return distances;
	}
	public List<String> readCities(String distancesString){
		Set<String> noDuplicates = new HashSet<String>();
		List<String> sDistances = Arrays.asList(distancesString.split("\n"));
		for (String wire : sDistances) {
			String[] splitA = wire.split(" to ");
			String[] splitB = splitA[1].split(" = ");
				noDuplicates.add(splitA[0]);
				noDuplicates.add(splitB[0]);
		}
		return new ArrayList<String>(noDuplicates);
		
	}
	
	
}
class Distance{
	String cityA;
	String cityB;
	int distance;
	Distance(String cityA, String cityB, int distance){
		this.cityA = cityA;
		this.cityB = cityB;
		this.distance = distance;
	}
}
class Route{
	
}
