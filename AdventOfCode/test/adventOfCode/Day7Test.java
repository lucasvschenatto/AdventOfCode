package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day7Test {
	private Day7 d;
	@Test
	public void imply() {
		signalFor("123 -> x","x",123);
	}
	@Test
	public void not(){
		signalFor("NOT 1 -> f","f",65534);
		signalFor("NOT 0 -> f","f",65535);
	}
	@Test
	public void or(){
		signalFor("2 OR 1 -> f","f",3);
		signalFor("8 OR 4 -> f","f",12);
		signalFor("7 OR 4 -> f","f",7);
	}
	@Test
	public void and(){
		signalFor("2 AND 1 -> f","f",0);
		signalFor("3 AND 1 -> f","f",1);
		signalFor("7 AND 4 -> f","f",4);
	}
	@Test
	public void lShift(){
		signalFor("2 LSHIFT 1 -> f","f",4);
		signalFor("3 LSHIFT 1 -> f","f",6);
		signalFor("4 LSHIFT 1 -> f","f",8);
		signalFor("7 LSHIFT 3 -> f","f",56);
		signalFor("1 LSHIFT 4 -> f","f",16);
	}
	@Test
	public void rShift(){
		signalFor("2 RSHIFT 1 -> f","f",1);
		signalFor("15 RSHIFT 1 -> f","f",7);
	}
	@Test
	public void manyEntry(){
		String circuit = "123 -> x"
				+ "\n456 -> y"
				+ "\nx AND y -> d"
				+ "\nx OR y -> e"
				+ "\nx LSHIFT 2 -> f"
				+ "\ny RSHIFT 2 -> g"
				+ "\nNOT x -> h"
				+ "\nNOT y -> i";
		signalFor("123 -> x"
				+ "\n10 -> y","y",10);
		signalFor(circuit,"d",72);
		signalFor(circuit,"e",507);
		signalFor(circuit,"f",492);
		signalFor(circuit,"g",114);
		signalFor(circuit,"h",65412);
		signalFor(circuit,"i",65079);
		signalFor(circuit,"x",123);
		signalFor(circuit,"y",456);
	}	
	@Test
	public void overrideSignal(){
		d = Day7.instantiate("123 -> x");
		int first = d.signalOf("x");
		assertEquals(123,first);
		d.overrideSignal("x",9);
		int second = d.signalOf("x");
		assertEquals(9,second);
	}
	@Test
	public void eraseSignals(){
		d = Day7.instantiate("123 -> x");
		d.overrideSignal("x",9);
		int first = d.signalOf("x");
		assertEquals(9,first);
		d.eraseSignals();
		int second = d.signalOf("x");
		assertEquals(123,second);
	}

	private void signalFor(String circuit, String wire, int expected) {
		d = Day7.instantiate(circuit);
		int actual = d.signalOf(wire);
		assertEquals(expected,actual);
	}

}
