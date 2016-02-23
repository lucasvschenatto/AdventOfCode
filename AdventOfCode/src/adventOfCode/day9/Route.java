package adventOfCode.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Route {
	private final List<String> cities;
	private final List<String> routes;
	private final List<CityDistance> cityDistances;
	private final List<Integer> routeDistances;
	public Route(String input){
		cities = readCities(input);
		cityDistances = readDistances(input);
		routes = allPossibleRoutes(cities);		
		routeDistances = routeDistancesFor(routes,cityDistances);
	}
	private List<String> allPossibleRoutes(List<String> cities){
		List<String> allRoutes = new ArrayList<String>();
		List<String> usedCities = new ArrayList<String>(); 
		mountRoutes(cities, usedCities, allRoutes);
		return allRoutes;
	}
	public int shortest(){
		Integer shortest = Integer.MAX_VALUE;
		for (Integer current : routeDistances)
			if(current < shortest)
				shortest = current;
		return shortest.intValue();
	}
	public int longest(){
		Integer longest = Integer.MIN_VALUE;
		for (Integer current : routeDistances)
			if(current > longest)
				longest = current;
		return longest.intValue();
	}
	private List<Integer> routeDistancesFor(List<String> routes, List<CityDistance> distances) {
		List<Integer> routeDistances = new ArrayList<Integer>();
		for (String route : routes) {
			int current = 0;
			String[] cities = route.split(" ");
			for(int i = 0; i<(cities.length-1);i++)
				for (CityDistance distance : distances) 
					if( distance.equals(cities[i],cities[i+1]) ){
							current += distance.distance;
							break;
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
	private List<CityDistance> readDistances(String distancesString){
		List<CityDistance> distances = new ArrayList<CityDistance>();
		List<String> lDistances = Arrays.asList(distancesString.split("\n"));
		for (String d : lDistances) {
			d = d.replace(" to ", " ").replace(" = ", " ");
			String[] split = d.split(" ");
			distances.add(new CityDistance(split[0], split[1], Integer.valueOf(split[2])));
		}
		return distances;
	}
	private List<String> readCities(String distancesString){
		Set<String> noDuplicates = new HashSet<String>();
		List<String> lDistances = Arrays.asList(distancesString.split("\n"));
		for (String d : lDistances) {
			d = d.replace(" to "," ").replace(" = ", " ");
			String[] split = d.split(" ");
			noDuplicates.add(split[0]);
			noDuplicates.add(split[1]);
		}
		return new ArrayList<String>(noDuplicates);		
	}
}
