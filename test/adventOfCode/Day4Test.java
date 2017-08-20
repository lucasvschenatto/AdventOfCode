package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day4Test {

	@Test
	public void hashCompletingNumber() {
		hashCompletingNumberFor("abcdef",609043, 5);
		hashCompletingNumberFor("pqrstuv",1048970, 5);
	}

	private void hashCompletingNumberFor(String key, int expected, int zeroes) {
		Day4 d = new Day4();
		int actual = d.numberToGenerateHashStartingWithGivenZeroes(key, zeroes);
		assertEquals(expected, actual);
	}

}
