package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

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
		public void internalDoubleQuote(){
			inMemorySpaceFor("\"\\\"\"",1);
			inMemorySpaceFor("\"aaa\"aaa\"",7);
		}
		private void inMemorySpaceFor(String list, int expected){
			d = new Day8();
			d.spaceOf(list);
			int actual = d.getInMemorySpace();
			assertEquals(expected,actual);
		}
	}	
}
