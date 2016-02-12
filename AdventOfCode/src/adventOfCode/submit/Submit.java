package adventOfCode.submit;


import javax.swing.JOptionPane;

import adventOfCode.*;

public class Submit {

	public static void main(String[] args) throws Exception {
		while(true){
			String userChoice = "";
			for(boolean valid = false;valid==false;){
				userChoice = JOptionPane.showInputDialog("Enter challenge number (1-25)\nNo number exit application");
				try{
					Integer.parseInt(userChoice);
					valid = true;
				}catch(NumberFormatException e){
					return;
				}
			}			
			String path = "../AdventOfCode/inputs/day"+userChoice+".txt";
			String input = new PuzzleImput(path).getInOneLine();
			Challenge day = new ChallengeFactory().create(userChoice);
			String answer = "Part1: "+day.part1(input)+"\nPart2: "+ day.part2(input);
			JOptionPane.showMessageDialog(null, answer);
		}		
	}

}
