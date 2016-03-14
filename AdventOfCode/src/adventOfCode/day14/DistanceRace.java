package adventOfCode.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class DistanceRace implements Race{
		private int maxScore = Integer.MIN_VALUE;
		private List<Reindeer> reindeer = new ArrayList<Reindeer>();
		private Map<Reindeer, Integer> result = new HashMap<Reindeer, Integer>();
		public DistanceRace (String reindeers){
			for(String r : reindeers.split("\n"))
				reindeer.add(new Reindeer(r));
		}
		public int longest(int time){
			for(Reindeer r: reindeer){
				r.fly(time);
				result.put(r, Integer.valueOf(r.getDistance()));
			}
			return getWinnersScore();
		}
		private int getWinnersScore(){
			result.values().forEach(new Consumer<Integer>() {
				@Override
				public void accept(Integer t) {
					if(maxScore<t.intValue())
						maxScore = t.intValue();
				}
			});
			return maxScore;
		}
		@Override
		public int run(int time) {
			return longest(time);
		}
}
