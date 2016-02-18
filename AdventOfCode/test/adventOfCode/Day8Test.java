package adventOfCode;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.*;

public class Day8Test {
	public static class CodeSpace extends Day8Test{
		Day8 d;
		@Test
		public void empty(){
			codeSpaceFor("",0);
		}
		@Test
		public void notEmpty() {
			codeSpaceFor("\"\"",2);
			codeSpaceFor("\"a\"",3);
		}
		private void codeSpaceFor(String list, int expected){
			d = new Day8();
			d.spaceOf(list);
			int actual = d.getCodeSpace();
			assertEquals(expected,actual);
		}
	}
	public static class InMemorySpace extends Day8Test{
		Day8 d;
		@Test
		public void empty(){
			inMemorySpaceFor("",0);
		}
		@Test
		public void surroundingDoubleQuote() {
			inMemorySpaceFor("\"\"",0);
			inMemorySpaceFor("\"a\"",1);
			inMemorySpaceFor("\"abc\"",3);
		}
		@Test
		public void loneDoubleQuote(){
			inMemorySpaceFor("\"\\\"\"",1);
			inMemorySpaceFor("\"aaa\\\"aaa\"",7);
		}
		@Test
		public void singleBackSlash(){
			inMemorySpaceFor("\"\\\\\"", 1);
			inMemorySpaceFor("\"\\\\a\\\\\"", 3);
		}
		@Test
		public void ASCIICode(){
			inMemorySpaceFor("\"\\x27\"", 1);
			inMemorySpaceFor("\"\\xd8\\x00\"", 2);
		}
		@Test
		public void notASCIICode(){
			d = new Day8();
			try{
			d.spaceOf("\"\\xuy\"");
			fail();
			}
			catch(Exception e){}
		}
		@Test
		public void newLine(){
			inMemorySpaceFor("\"z\"\n", 1);
			inMemorySpaceFor("\"z\"\n\"z\"", 2);
		}
		@Test
		public void manyLines(){
			fail("Not implemented yet");
		}
		private void inMemorySpaceFor(String list, int expected){
			d = new Day8();
			d.spaceOf(list);
			int actual = d.getInMemorySpace();
			assertEquals(expected,actual);
		}
	}	
}
