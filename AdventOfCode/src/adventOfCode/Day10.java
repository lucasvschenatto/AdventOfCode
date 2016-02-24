package adventOfCode;

import adventOfCode.submit.Challenge;

public class Day10 implements Challenge{

	public String lookAndSayTurns(String sequence, int turns) {
		String result = sequence;
		for(int i = 1; i<= turns; i++){
			result = lookAndSay(result);
		}
		return result;
	}

	private String lookAndSay(String sequence) {
		String result = "";
		for(int i = 0; i<sequence.length();){
			char current = sequence.charAt(i);
			int count = 0;
				while(i<sequence.length() && current == sequence.charAt(i)){
					count++;
					i++;
				}
			result = result.concat(count+ String.valueOf(current));
		}
		return result;		
	}

	@Override
	public String part1(String input) {
		String result = lookAndSayTurns(input, 40);
		return result;
	}

	@Override
	public String part2(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
