package adventOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import adventOfCode.day5.*;

public class Day5 implements Challenge{
	List<Strategy> properties;

	public Day5() {
		properties = new ArrayList<Strategy>(EnumSet.allOf(Strategy.class));
	}
	Day5(Strategy property){
		properties = new ArrayList<Strategy>();
		properties.add(property);	
	}
	Day5(StrategySet strategySet){
		properties = strategySet.getRules();
	}
	
	public int countNices(String strings) {
		List<String> s = Arrays.asList(strings.split("\n"));
		int count = 0;
		for (String string : s) {
			boolean isNice = true;
			for (Strategy property : properties)				
				if (property.check(string) == false)
					isNice = false;
			if(isNice)	count++;
		}		
		return count;
	}
	
	@Override
	public String part1(String input) {
		return String.valueOf(new Day5(StrategySet.OLDRULES).countNices(input));
	}
	@Override
	public String part2(String input) {
		return String.valueOf(new Day5(StrategySet.NEWRULES).countNices(input));
	}	
}
