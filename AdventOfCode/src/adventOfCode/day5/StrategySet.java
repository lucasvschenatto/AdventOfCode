package adventOfCode.day5;

import java.util.Arrays;
import java.util.List;

public enum StrategySet{
	OLDRULES(Arrays.asList(Strategy.THREEVOWELS, Strategy.LETTERTWICE, Strategy.REJECTEDSUBSTRING)),
	NEWRULES(Arrays.asList(Strategy.PAIRNOTOVERLAPING, Strategy.REPEATWITHONEBETWEEN));
	private List<Strategy> rules;
	StrategySet(List<Strategy> rules){
		this.rules = rules;
	}
	public List<Strategy> getRules(){
		return rules;
	}
}