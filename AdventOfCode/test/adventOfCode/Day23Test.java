package adventOfCode;

import static org.junit.Assert.*;
import org.junit.*;
import adventOfCode.day23.*;

public class Day23Test {
	private Computer comp;
	private void givenA(int a){
		given(a,0);
	}
	private void givenB(int b){
		given(0,b);
	}
	private void given(int a, int b){
		comp = new Computer(a,b);
	}
	private void whenRun(String program){
		comp.run(program);
	}
	private void thenA(int a){
		assertEquals(a,comp.getA());
	}

	private void thenB(int b){
		assertEquals(b,comp.getB());
	}
	@Test
	public void hlfA() {
		givenA(2);
		whenRun("hlf a");
		thenA(1);
	}
	@Test
	public void hlfB() {
		givenB(10);
		whenRun("hlf b");
		thenB(5);
	}
	@Test
	public void tplA() {
		givenA(2);
		whenRun("tpl a");
		thenA(6);
	}
	@Test
	public void tplB() {
		givenB(4);
		whenRun("tpl b");
		thenB(12);
	}
	@Test
	public void incA(){
		givenA(0);
		whenRun("inc a");
		thenA(1);
	}
	@Test
	public void incB(){
		givenB(0);
		whenRun("inc b");
		thenB(1);
	}
	
	@Test
	public void twoInstructions(){
		given(0,0);
		whenRun("inc a"
				+ "\ninc a");
		thenA(2);
	}
	@Test
	public void manyInstructions(){
		given(0,0);
		whenRun("inc a"
				+ "\ninc a"
				+ "\ninc b"
				+ "\nhlf a"
				+ "\ntpl b");
		thenA(1);
		thenB(3);
	}
	@Test
	public void jmp(){
		given(0,0);
		whenRun("jmp 2"
				+ "\ninc a"
				+ "\ninc b");
		thenA(0);
		thenB(1);
	}
	@Test
	public void jie(){
		givenA(0);
		whenRun("ninc a"
				+ "\njie a, 10"
				+ "\ninc a"
				+ "\ninc a"
				+ "\ninc a"
				+ "\njie a, 2"
				+ "\ninc a"
				+ "\ninc a");
		thenA(5);
	}
	@Test
	public void jio(){
		givenA(0);
		whenRun("ninc a"
				+ "\njio a, 10"
				+ "\ninc a"
				+ "\ninc a"
				+ "\ninc a"
				+ "\njio a, 2"
				+ "\ninc a"
				+ "\ninc a");
		thenA(1);
	}
}
