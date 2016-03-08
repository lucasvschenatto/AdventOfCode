package adventOfCode.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Race {
	private int longest = Integer.MIN_VALUE;
	private List<Reindeer> reindeer = new ArrayList<Reindeer>();
	private Map<Reindeer, Integer> result = new HashMap<Reindeer, Integer>();
	public Race (String reindeers){
		for(String r : reindeers.split("\n"))
			reindeer.add(new Reindeer(r));
	}
	public int longest(int time){
		for(Reindeer r: reindeer)
			result.put(r, Integer.valueOf(r.fly(time)));
		result.values().forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				if(longest<t.intValue())
					longest = t.intValue();
			}
		});
		return longest;
	}
	public int morePoints(int time){
		return 0;
	}
}
