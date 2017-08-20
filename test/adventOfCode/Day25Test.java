package adventOfCode;

import static org.junit.Assert.*;


import static org.hamcrest.CoreMatchers.*;
import org.junit.*;
import adventOfCode.day25.*;

public class Day25Test {
	@Test
	public void additionCodeAt(){
		aCodeAtIs(1,1,1);
		aCodeAtIs(2,1,2);
		aCodeAtIs(1,2,3);
		aCodeAtIs(3,1,4);
		aCodeAtIs(2,2,5);
		aCodeAtIs(1,3,6);
		aCodeAtIs(4,1,7);
		aCodeAtIs(3,2,8);
		aCodeAtIs(2,3,9);
		aCodeAtIs(1,4,10);
	}
	
	@Test
	public void calculationCodeAt(){
		cCodeAtIs(1,1,20151125);
		cCodeAtIs(2,1,31916031);
		cCodeAtIs(1,2,18749137);
		cCodeAtIs(3,1,16080970);
		cCodeAtIs(2,2,21629792);
		cCodeAtIs(1,3,17289845);
		cCodeAtIs(4,1,24592653);
		cCodeAtIs(3,2,8057251);
		cCodeAtIs(2,3,16929656);
		cCodeAtIs(1,4,30943339);
	}

	private void aCodeAtIs(long row, long col, long expected) {
		Coder c = new AdditionCoder();
		assertThat("by addition code at "+row+","+col+" must be",c.getCode(row,col),equalTo(expected));
	}
	private void cCodeAtIs(long row, long col, long expected) {
		Coder c = new CalculationCoder();
		assertThat("by calculation code at "+row+","+col+" must be",c.getCode(row,col),equalTo(expected));
	}
}
