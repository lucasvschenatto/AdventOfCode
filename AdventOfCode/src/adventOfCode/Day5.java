package adventOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class Day5 implements Challenge{
	List<Strategy> properties;
	public Day5(){
		properties = new ArrayList<Strategy>(EnumSet.allOf(Strategy.class));
	}
	Day5(Strategy property){
		properties = new ArrayList<Strategy>();
		properties.add(property);	
	}
	Day5(StrategySet strategySet){
		properties = strategySet.getRules();
	}
	@Override
	public String part1(String input) {
		return String.valueOf(new Day5(StrategySet.OLDRULES).countNices(input));
	}
	@Override
	public String part2(String input) {
		return String.valueOf(new Day5(StrategySet.NEWRULES).countNices(input));
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
	
	enum Strategy {
		THREEVOWELS ( (subject) ->{
			int vowels = 0;
			for (int i = 0; i<subject.length();i++)
				if("aeiou".indexOf(subject.charAt(i)) >= 0)
					vowels++;
			return (vowels>=3)? true:false;
		}),
		LETTERTWICE ( (subject) ->{
			for(int i = 0; i < (subject.length()-1); i++)
				if(subject.charAt(i) == subject.charAt(i+1))
					return true;
			return false;
		}),
		REJECTEDSUBSTRING ( (subject) ->{
			if(subject.contains("ab") || subject.contains("cd")
			|| subject.contains("pq") || subject.contains("xy"))
				return false;
			return true;
		}),
		PAIRNOTOVERLAPING( (subject) ->{
			for(int i = 0; i < (subject.length()-1); i++){
				for(int j = i+2; j < subject.length()-1; j++)
					if(subject.substring(i,i+2).equals(subject.substring(j,j+2)))
						return true;
			}
			return false;
		}),
		REPEATWITHONEBETWEEN( (subject) ->{
			for(int i = 0; i < (subject.length()-2); i++)
				if(subject.charAt(i) == subject.charAt(i+2))
					return true;
			return false;
		});
		
		private Command action;
		private Strategy(Command c){
			action = c;
		}
		private boolean check(String subject){
			return action.check(subject);
		}
		private interface Command{
			boolean check(String subject);
		}
	}
	enum StrategySet{
		OLDRULES(Arrays.asList(Strategy.THREEVOWELS, Strategy.LETTERTWICE, Strategy.REJECTEDSUBSTRING)),
		NEWRULES(Arrays.asList(Strategy.PAIRNOTOVERLAPING, Strategy.REPEATWITHONEBETWEEN));
		private List<Strategy> rules;
		StrategySet(List<Strategy> rules){
			this.rules = rules;
		}
		List<Strategy> getRules(){
			return rules;
		}
	}
}
