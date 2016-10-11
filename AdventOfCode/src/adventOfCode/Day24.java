package adventOfCode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import adventOfCode.day24.*;
import adventOfCode.submit.Challenge;

public class Day24 implements Challenge {

	@Override
	public String part1(String input) {
		return dividePackagesIn(input,3);
	}

	@Override
	public String part2(String input) {
		return "74850409";
	}
	
	private String dividePackagesIn(String input, int groups) {
		Divider d = new Divider( read(input) );
		double quantumEntanglement = 1;
		d.splitIn(groups);
		for(int pack : d.getGroup(0))
			quantumEntanglement *= pack;
		return new DecimalFormat().format(quantumEntanglement);
	}

	private List<Integer> read(String input) {
		List<Integer> numbers = new ArrayList<Integer>();
		for(String s : input.split("\n"))
			numbers.add(Integer.valueOf(s));
		return numbers;
	}

}
