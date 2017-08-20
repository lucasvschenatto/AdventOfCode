package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day12Test {

	@Test
	public void sumNumbers() {
		sumNumbersFor("",0);
		sumNumbersFor("[]",0);
		sumNumbersFor("{}",0);
		sumNumbersFor("[1]",1);
		sumNumbersFor("[1,2]",3);
		sumNumbersFor("[1,2,3]",6);
		sumNumbersFor("[10,20,30]",60);
		sumNumbersFor("{\"a\":2,\"b\":4}",6);
		sumNumbersFor("[[[3]]]",3);
		sumNumbersFor("{\"a\":{\"b\":4},\"c\":-1}",3);
		sumNumbersFor("[{\"a\":[-1,1]}]",0);
		sumNumbersFor("[-1,{\"a\":1}]",0);
	}
	@Test
	public void sumNonReds(){
		sumNonRedsFor("",0);
		sumNonRedsFor("[1,2,3]",6);
		sumNonRedsFor("[10,20,30]",60);
		sumNonRedsFor("[1,{\"c\":\"red\",\"b\":2},3]",4);
		sumNonRedsFor("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}",0);
		sumNonRedsFor("[1,\"red\",5]",6);
		sumNonRedsFor("[1,{\"c\":\"red\",\"b\":2},-3]",-2);
	}
	
	private void sumNonRedsFor(String jSON, int expected) {
		Day12 d = new Day12();
		int actual = d.sumAllNonReds(jSON);
		assertEquals(expected, actual);
	}
	private void sumNumbersFor(String jSON, int expected) {
		Day12 d = new Day12();
		int actual = d.sumAllNumbers(jSON);
		assertEquals(expected, actual);
	}

}
