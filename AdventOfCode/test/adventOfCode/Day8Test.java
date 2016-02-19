package adventOfCode;

import static org.junit.Assert.*;

import org.junit.*;


public class Day8Test {
	protected Day8 d;
	public static class Part1{
		public static class CodeSpace extends Day8Test{
			@Test
			public void empty(){
				codeSpaceFor("",0);
			}
			@Test
			public void notEmpty() {
				codeSpaceFor("\"\"",2);
				codeSpaceFor("\"a\"",3);
			}
			@Test
			public void manyLines() {
				codeSpaceFor("\"\"\n\"\"",4);
				codeSpaceFor("\"a\"\n\"a\"",6);
				codeSpaceFor("\"abc\"\n\"def\"",10);
				codeSpaceFor("\"\""
						+ "\n\"abc\""
						+ "\n\"aaa\\\"aaa\""
						+ "\n\"\\x27\"",2+5+10+6);
			}
			private void codeSpaceFor(String list, int expected){
				d = new Day8();
				d.spaceOf(list);
				int actual = d.getCodeSpace();
				assertEquals(expected,actual);
			}
		}
		public static class InMemorySpace extends Day8Test{
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
			@Test@Ignore
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
				inMemorySpaceFor("\"\""
						+ "\n\"abc\""
						+ "\n\"aaa\\\"aaa\""
						+ "\n\"\\x27\"",0+3+7+1);
			}
			private void inMemorySpaceFor(String list, int expected){
				d = new Day8();
				d.spaceOf(list);
				int actual = d.getInMemorySpace();
				assertEquals(expected,actual);
			}
		}	
		public static class SpaceDifference extends Day8Test{
			@Test
			public void getSpaceDifference(){
				spaceDifferenceFor("\"\""
						+ "\n\"abc\""
						+ "\n\"aaa\\\"aaa\""
						+ "\n\"\\x27\"", (2+5+10+6)-(0+3+7+1));
			}
			private void spaceDifferenceFor(String list, int expected){
				d = new Day8();
				d.spaceOf(list);
				int actual = d.getInMemoryDifference();
				assertEquals(expected,actual);
			}
		}
	}
	public static class Part2{
		public static class EncodeNewString extends Day8Test{
			@Test
			public void empty(){
				encodedSpaceFor("",2);
			}
			@Test
			public void surroundingDoubleQuotes(){
				encodedSpaceFor("\"\"",6);
			}
			@Test
			public void letter(){
				encodedSpaceFor("\"abc\"",9);
			}
			@Test
			public void loneDoubleQuote(){
				encodedSpaceFor("\"aaa\\\"aaa\"",16);
			}
			@Test
			public void singleBackSlash(){
				encodedSpaceFor("\"aaa\\\\aaa\"",16);
			}
			@Test
			public void ASCIICode(){
				encodedSpaceFor("\"\\x27\"",11);
			}
			@Test
			public void manyLines(){
				encodedSpaceFor("\"\""
						+ "\n\"abc\""
						+ "\n\"aaa\\\"aaa\""
						+ "\n\"\\x27\"",6 + 9 + 16 + 11);
			}
			private void encodedSpaceFor(String list, int expected){
				d = new Day8();
				d.spaceOf(list);
				int actual = d.getEncodedSpace();
				assertEquals(expected,actual);
			}
		}
		public static class SpaceDifference extends Day8Test{
			@Test
			public void getSpaceDifference(){
				spaceDifferenceFor("\"\""
						+ "\n\"abc\""
						+ "\n\"aaa\\\"aaa\""
						+ "\n\"\\x27\"", (6+9+16+11)-(2+5+10+6));
			}
			private void spaceDifferenceFor(String list, int expected){
				d = new Day8();
				d.spaceOf(list);
				int actual = d.getEncodedDifference();
				assertEquals(expected,actual);
			}
		}
	}
}
	
