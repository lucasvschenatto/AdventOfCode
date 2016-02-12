package adventOfCode;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Day5 implements Challenge{
	List<Strategy> requirements;
	public Day5(){
		requirements = new ArrayList<Strategy>(EnumSet.allOf(Strategy.class));
	}
	Day5(Strategy strategy){
		requirements = new ArrayList<Strategy>();
		requirements.add(strategy);	
	}
	@Override
	public String part1(String input) {
		return String.valueOf(countNices(input));
	}
	@Override
	public String part2(String input) {
		return String.valueOf("");
	}
	public int countNices(String strings) {
		for (Strategy requirement : requirements) {
			if (requirement.check(strings) == false)
				return 0;
		}
		return 1;
	}
	
	enum Strategy {
		THREEVOWELS ( (subject) ->{
			int vowels = 0;
			for (int i = 0; i<subject.length();i++){
				switch (subject.charAt(i)){
				case 'a':
					vowels++;
					break;
				case 'e':
					vowels++;
					break;
				case 'i':
					vowels++;
					break;
				case 'o':
					vowels++;
					break;
				case 'u':
					vowels++;
					break;
				};
			}
			return (vowels>=3)? true:false;
		}),
		LETTERTWICE ( (subject) ->{
			char last = 0;
			for (int i = 0; i<subject.length();i++){
				if (subject.charAt(i) == last)
					return true;
				last = subject.charAt(i);
			}
			return false;
		}),
		REJECTEDSTRING ( (subject) ->{
			return true;
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
}
