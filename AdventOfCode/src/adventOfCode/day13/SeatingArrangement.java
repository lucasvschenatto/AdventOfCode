package adventOfCode.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SeatingArrangement {
	private final List<String> guests;
	private final List<GuestLiking> guestsLiking;
	public SeatingArrangement(String guestList){
		guests = readGuests(guestList);
		guestsLiking = readGuestsLiking(guestList);
	}
	public void addGuest(String newGuest){
		guests.add(newGuest);
	}
	public int happier(){
		List<String> arrangements = allPossibleArrangements(guests);		
		List<Integer> happinessUnits = happinessFor(arrangements,guestsLiking);
		Integer longest = Integer.MIN_VALUE;
		for (Integer current : happinessUnits)
			if(current > longest)
				longest = current;
		return longest.intValue();
	}
	private List<String> allPossibleArrangements(List<String> guests){
		List<String> allArrangements = new ArrayList<String>();
		List<String> usedGuests = new ArrayList<String>(); 
		mountArrangements(guests, usedGuests, allArrangements);
		return allArrangements;
	}
	private List<Integer> happinessFor(List<String> arrangements, List<GuestLiking> guestsLiking) {
		List<Integer> happinessUnits = new ArrayList<Integer>();
		for (String arrangement : arrangements) {
			int current = 0;
			String[] guests = arrangement.split(" ");
			for(int i = 0; i<(guests.length-1);i++)
				for (GuestLiking guestLiking : guestsLiking) 
					if( guestLiking.equals(guests[i],guests[i+1]) ){
							current += guestLiking.happinessPoints;
						}
			for (GuestLiking guestLiking : guestsLiking) 
				if( guestLiking.equals(guests[0],guests[guests.length-1]) ){
						current += guestLiking.happinessPoints;
					}
			happinessUnits.add(Integer.valueOf(current));
		}
		return happinessUnits;
	}
	private void mountArrangements(List<String> guestsToArrange,List<String> guestsArranged, List<String> arrangements) {
		if(guestsToArrange.size()>0){
			for (String guest : guestsToArrange) {
				List<String> remaining = new ArrayList<String>(guestsToArrange);
				remaining.remove(guest);
				List<String> used = new ArrayList<String>(guestsArranged);
				used.add(guest);
				mountArrangements(remaining, used, arrangements);
			}
		}
		else{
			StringBuilder route = new StringBuilder();
			for (String city : guestsArranged)
				route.append(city + " ");
			arrangements.add(route.toString().trim());
		}
	}
	private List<GuestLiking> readGuestsLiking(String sGuestsLiking){
		List<GuestLiking> guestsLiking = new ArrayList<GuestLiking>();
		List<String> lLikings = Arrays.asList(sGuestsLiking.split("\n"));
		for (String liking : lLikings) {
			String[] split = liking.split(" ");
			split[10] = split[10].replace(".","");
			int likeDislike = (split[2].equals("gain"))? 1: -1;
			guestsLiking.add(new GuestLiking(split[0], split[10], likeDislike * Integer.valueOf(split[3])));
		}
		return guestsLiking;
	}
	private List<String> readGuests(String guestsLiking){
		Set<String> noDuplicates = new HashSet<String>();
		List<String> lguests = Arrays.asList(guestsLiking.split("\n"));
		for (String guestLiking : lguests) {
			String guest = guestLiking.substring(0, guestLiking.indexOf(" "));
			noDuplicates.add(guest);
		}
		return new ArrayList<String>(noDuplicates);		
	}
}
