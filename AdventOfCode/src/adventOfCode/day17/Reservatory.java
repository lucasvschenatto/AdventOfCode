package adventOfCode.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class Reservatory {
	private List<ExclusiveInt> containers;
	private List<Set<ExclusiveInt>> waysWithMinimum;
	private List<Set<ExclusiveInt>> fitingWays;
	private List<Set<ExclusiveInt>> allWays;
	private int eggnog;
	public Reservatory(int eggnog,String containers){
		this.eggnog = eggnog;
		this.containers = new ArrayList<ExclusiveInt>();
		for(String c : containers.split("\n"))
			if(!c.isEmpty())
				this.containers.add(ExclusiveInt.valueOf(c));
	}
	public int waysToFit(){
		loadFitingWays();
		return fitingWays.size();
	}
	public boolean fit(){
		int remaining = eggnog;
		for(ExclusiveInt container : containers)
			remaining -= container.intValue();
		return remaining == 0;
	}
	public void loadFitingWays(){
		if(fitingWays == null){
			fitingWays = new ArrayList<Set<ExclusiveInt>>();			
			if(allWays == null)loadAllWays();			
			allWays.forEach((way)->{
				if(doesEggnogFitInWay(way))
					fitingWays.add(way);
			});
		}
	}
	private boolean doesEggnogFitInWay(Set<ExclusiveInt> way) {
		I sum = new I(0);
		way.forEach((container)->sum.value+=container.intValue());
		return sum.value==eggnog;
	}
	private void loadAllWays() {
		allWays = allWaysFromIndex(0);
	}
	
	public List<Set<ExclusiveInt>> allWaysFromIndex(int containerIndex) {
		List<Set<ExclusiveInt>> currentWays = allWaysAfterIndex(containerIndex);
		addWaysWithContainerToCurrentWays(containerIndex, currentWays);		
		addSingleWayWithContainerToCurrentWays(containerIndex, currentWays);		
		return currentWays;
	}
	private void addSingleWayWithContainerToCurrentWays(int containerIndex, List<Set<ExclusiveInt>> currentWays) {
		Set<ExclusiveInt> singleWay = createWayWithContainer(containerIndex);
		currentWays.add(singleWay);
	}
	private List<Set<ExclusiveInt>> allWaysAfterIndex(int index) {
		if (index < containers.size()-1)
			return allWaysFromIndex(index+1);
		else
			return new ArrayList<Set<ExclusiveInt>>();
	}
	private void addWaysWithContainerToCurrentWays(int containerIndex, List<Set<ExclusiveInt>> ways) {
		List<Set<ExclusiveInt>> oldWays = new ArrayList<Set<ExclusiveInt>>(ways);
		for(Set<ExclusiveInt> oldWay: oldWays){
			Set<ExclusiveInt> newWay = createWayWithContainer(containerIndex);
			newWay.addAll(oldWay);
			ways.add(newWay);
		}
	}
	private Set<ExclusiveInt> createWayWithContainer(int containersIndex){
		Set<ExclusiveInt> newWay = new ComparableHashSet<ExclusiveInt>();
		newWay.add(containers.get(containersIndex));
		return newWay;
	}
	public int minimumContainersToFit() {
		loadFitingWays();
		I minimum = new I(Integer.MAX_VALUE);
		fitingWays.forEach((way)->{
			if(minimum.value>way.size())
				minimum.value = way.size();
		});
		return minimum.value;
	}
	public int waysWithMinimum() {
		loadWaysWithMinimumContainers();
		return waysWithMinimum.size();
	}
	private void loadWaysWithMinimumContainers() {
		if(waysWithMinimum == null){
			waysWithMinimum = new ArrayList<Set<ExclusiveInt>>();
			loadFitingWays();
			I minimum = new I(minimumContainersToFit());
			fitingWays.forEach((way)->{
				if(way.size() == minimum.value)
					waysWithMinimum.add(way);
			});
			
		}
	}
	private class I{
		private int value;
		private I(int value){this.value = value;}
	}
}
