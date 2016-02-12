package adventOfCode;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class PuzzleImput {
	private String path;
	public PuzzleImput(String path){
		this.path = path;
	}
	public List<String> getLines() throws Exception{
//		File f = new File("../AdventOfCode/inputs/day2.txt");
//		if (f.isFile()){
//			FileReader fr = new FileReader("../AdventOfCode/inputs/day2.txt");
//			BufferedReader b = new BufferedReader(fr);
//			String line = b.readLine();
//			System.out.println(line);
//			b.close();
//		}
//		return null;
			return Files.readAllLines(Paths.get(path));
			
		
	}
	public String getLine(){
		return null;
	}
}
