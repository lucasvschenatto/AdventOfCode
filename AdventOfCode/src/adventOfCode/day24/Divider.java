package adventOfCode.day24;

import java.util.ArrayList;
import java.util.List;

public class Divider {

	private List<Integer> packages;
	private List<List<Integer>> groups;
	private int balance;

	public Divider(List<Integer> packages) {
		this.packages = packages;
		this.groups = new ArrayList<List<Integer>>();
	}

	public void splitIn(int numberOfGroups) {
		balance = sumOf(packages)/numberOfGroups;
		while(!packages.isEmpty()){
			createGroupInBalance();
		}
	}

	private void createGroupInBalance() {
		ArrayList<Integer> group = new ArrayList<Integer>();
		
		for(int i = packages.size() - 1; i >= 0; i--)
			if(sumOf(group)+packages.get(i) <= balance)
				group.add(packages.remove(i));	
		
		groups.add(group);
	}

	private int sumOf(List<Integer> group) {
		int sum = 0;
		for(int g : group)
			sum += g;
		return sum;
	}

	public int getBalanceWeight() {
		return balance;
	}

	public List<Integer> getGroup(int index) {
		return groups.get(index);
	}

}
