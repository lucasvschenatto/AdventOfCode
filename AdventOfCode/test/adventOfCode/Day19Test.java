package adventOfCode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

import adventOfCode.day19.Interpreter;
import adventOfCode.day19.NuclearFission;
import adventOfCode.day19.Replacement;

public class Day19Test {
	private static String rep1 = "H => HO";
	private static String rep2 = "H => OH";
	private static String rep3 = "H => Ba";
	private static String rep4 = "O => HH";
	private static String rep5 = "X => YY";
	private static String molecule1 = "HOHOHO";
	private static String molecule2 = "HOBaRd";
	private static String reps =  
			  rep1 + "\n"
			+ rep2 + "\n"
			+ rep3 + "\n"
			+ rep4 + "\n"
			+ rep5;
	private static String input1 = 
			  reps + "\n"
			+ "\n"
			+ molecule1;
	private static String input2 = 
			  reps + "\n"
			+ "\n"
			+ molecule2;
	public static class NuclearFissionTest{
		@Test
		public void possibleMolecules(){
			givenInput_ExpectPossibleMolecule(input1,"BaOHOHO");
			givenInput_ExpectPossibleMolecule(input1,"HOOHOHO");
			givenInput_ExpectPossibleMolecule(input1,"OHOHOHO");
			givenInput_ExpectPossibleMolecule(input1,"HOHOHHH");
			givenInput_ExpectPossibleMolecule(input1,"HOBaOHO");
			givenInput_ExpectPossibleMolecule(input1,"HOOHOHO");
			givenInput_ExpectPossibleMolecule(input1,"HOHHHHO");
			givenInput_ExpectPossibleMolecule(input1,"HOHOHOO");
		}
		@Test
		public void countPossibleMolecules(){
			givenInput_ExpectThisMuchPossibleMolecules(input1,10);
		}
		private void givenInput_ExpectThisMuchPossibleMolecules(String input, int expected) {
			NuclearFission n = new NuclearFission(input);
			assertEquals(expected, n.getPossibleNumber());
		}
		private void givenInput_ExpectPossibleMolecule(String input, String expected) {
			NuclearFission n = new NuclearFission(input);
			assertTrue(n.canMake(expected));
		}
	}
	public static class InterpreterTest{
		@Test
		public void readReplacements() {
			givenInput_ExpectsReplacement(rep1, rep1);
			givenInput_ExpectsReplacement(input1,rep1);
			givenInput_ExpectsReplacement(input1,rep2);
		}
		@Test
		public void readOnlyReplacementsAsReplacements(){
			givenInput_NotExpectsReplacement(input1,"");
			givenInput_NotExpectsReplacement(input1,"\n");
			givenInput_NotExpectsReplacement(input1,molecule1);
		}
		
		@Test
		public void readMolecule(){
			givenInput_ExpectsMolecule(input1,molecule1);
			givenInput_ExpectsMolecule(input2,molecule2);
		}
	
		private void givenInput_ExpectsMolecule(String input, String expected) {
			Interpreter i = new Interpreter(input);
			String actual = i.getMolecule();
			assertEquals(expected,actual);
		}
		private void givenInput_NotExpectsReplacement(String input, String notExpected) {
			boolean exists = replacementExists(input, notExpected);
			assertFalse("Replacement '"+notExpected+"' was found",exists);
		}
		private void givenInput_ExpectsReplacement(String input, String expected) {
			boolean exists = replacementExists(input, expected);
			assertTrue("Replacement '"+expected+"' not found",exists);
		}
		private boolean replacementExists(String input, String expected) {
			boolean exists;
			Interpreter i = new Interpreter(input);
			List<Replacement> replacements = i.getReplacements();
			exists = false;
			for(Replacement r : replacements)
				if (expected.equals(r.toString()))
					exists = true;
			return exists;
		}
	}
}
