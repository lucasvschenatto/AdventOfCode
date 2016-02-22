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
		// need to change this below method's first loop
		int i = routeDistancesFor(routes,distances);
		return 0;
	}
	private int routeDistancesFor(List<String> routes, List<Distance> distances) {
		int d = 0;
		for (String route : routes) {
			String[] cities = route.split(" ");
			for(int i = 0; i<(cities.length-1);i++){
				for (Distance distance : distances) {
					if(distance.cityA == cities[i] || distance.cityB == cities[i]){
						if(distance.cityA == cities[i+1] || distance.cityB == cities[i+1]){
							d = distance.distance;
						}
					}
				}
			}
		}
		return d;
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
