package adventOfCode.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class PointsRace implements Race{
		private int maxScore = Integer.MIN_VALUE;
		private List<Reindeer> reindeer = new ArrayList<Reindeer>();
		private Map<Reindeer, Integer> result = new HashMap<Reindeer, Integer>();
		public PointsRace (String reindeers){
			for(String r : reindeers.split("\n"))
				reindeer.add(new Reindeer(r));
		}
		public int morePoints(int time){
			for(int i=0; i<time;i++){
				int winningDistance = 0;
				List <Reindeer> leading = new ArrayList<Reindeer>();
				for(Reindeer r: reindeer){
					r.fly(1);
					int flied = r.getDistance();
					if (flied == winningDistance)
						leading.add(r);
					else if (flied > winningDistance){
						winningDistance = flied;
						leading.clear();
						leading.add(r);
					}
				}
				for( Reindeer r: leading)
					r.addPoint();
			}
			for(Reindeer r: reindeer)
				result.put(r, Integer.valueOf(r.getPoints()));
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
			return morePoints(time);
		}

}
