package adventOfCode.submit;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class PuzzleImput {
	private String path;
	public PuzzleImput(String path){
		this.path = path;
	}
	private List<String> getLines() {
//		File f = new File("../AdventOfCode/inputs/day2.txt");
//		if (f.isFile()){
//			FileReader fr = new FileReader("../AdventOfCode/inputs/day2.txt");
//			BufferedReader b = new BufferedReader(fr);
//			String line = b.readLine();
//			System.out.println(line);
//			b.close();
//		}
//		return null;
			try {
				return Files.readAllLines(Paths.get(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ArrayList<String>();
			}
			
		
	}
	public String getInOneLine(){
		List<String> lines = getLines();
		StringBuilder inOne = new StringBuilder();
		for (String line : lines) {
			if(inOne.length()==0)
				inOne.append(line);
			else
				inOne.append("\n"+line);
		}
		return inOne.toString();
	}
}
