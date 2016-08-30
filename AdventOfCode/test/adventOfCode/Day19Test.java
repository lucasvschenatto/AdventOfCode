package adventOfCode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

import adventOfCode.day19.Interpreter;
import adventOfCode.day19.Laboratory;
import adventOfCode.day19.OptimizedLaboratory;
import adventOfCode.day19.SingleManipulation;
import adventOfCode.day19.Replacement;

public class Day19Test {
	private static String rep1 = "H => HO";
	private static String rep2 = "H => OH";
	private static String rep3 = "H => Ba";
	private static String rep4 = "O => HH";
	private static String rep5 = "X => YY";
	private static String rep6 = "e => H";
	private static String rep7 = "U => XXX";
	private static String molecule1 = "HOHOHO";
	private static String molecule2 = "HOBaRd";
	private static String reps =  
			  rep1 + "\n"
			+ rep2 + "\n"
			+ rep3 + "\n"
			+ rep4 + "\n"
			+ rep5 + "\n"
			+ rep6 + "\n"
			+ rep7;
	private static String input1 = 
			  reps + "\n"
			+ "\n"
			+ molecule1;
	private static String input2 = 
			  reps + "\n"
			+ "\n"
			+ molecule2;
	static Interpreter makeInterpreter(String input){
		return new Interpreter(input);
	}
	static SingleManipulation makeNuclearFusion(String input){
		Interpreter i = new Interpreter(input);
		return new SingleManipulation(i.getFusions(),i.getMolecule());
	}
	public static class LaboratoryTest{
		@Test
		public void countSteps(){
			givenInputAndStartingMatter_ItTakesThisManySteps(input1,"HOHOHO",0);
			givenInputAndStartingMatter_ItTakesThisManySteps(input1,"HHOHO" ,1);
			givenInputAndStartingMatter_ItTakesThisManySteps(input1,"OOHO"  ,2);
			givenInputAndStartingMatter_ItTakesThisManySteps(input1,"OHO"   ,3);
			givenInputAndStartingMatter_ItTakesThisManySteps(input1,"OH"    ,4);
			givenInputAndStartingMatter_ItTakesThisManySteps(input1,"H"     ,5);
			givenInputAndStartingMatter_ItTakesThisManySteps(input1,"e"     ,6);
		}
		
		@Test
		public void acceptanceTest(){
			String acceptanceReplacements =
					  "e => H"  +"\n"
					+ "e => O"  +"\n"
					+ "H => HO" +"\n"
					+ "H => OH" +"\n"
					+ "O => HH";
			String acceptanceMolecule1 = "HOH";
			String acceptanceMolecule2 = "HOHOHO";
			String acceptanceInput1 = acceptanceReplacements + "\n\n" + acceptanceMolecule1;
			String acceptanceInput2 = acceptanceReplacements + "\n\n" + acceptanceMolecule2;
			givenInputAndStartingMatter_ItTakesThisManySteps(acceptanceInput1,"e",3);
			givenInputAndStartingMatter_ItTakesThisManySteps(acceptanceInput2,"e",6);
		}

		private void givenInputAndStartingMatter_ItTakesThisManySteps(String input, String startingMatter, int expected) {
			Laboratory l = new Laboratory(input,startingMatter);
			int actual = l.stepsToProduceMolecule();
			assertEquals(expected,actual);
		}
	}
	public static class OptimizedLaboratoryTest{
		@Test
		public void countSteps(){
			givenInputAndStartingMatter_ItTakesThisManySteps(input1,"H"     ,5);
			givenInputAndStartingMatter_ItTakesThisManySteps(input1,"e"     ,6);
		}
		private void givenInputAndStartingMatter_ItTakesThisManySteps(String input, String startingMatter, int expected) {
			Laboratory l = new OptimizedLaboratory(input,startingMatter);
			int actual = l.stepsToProduceMolecule();
			assertEquals(expected,actual);
		}
	}
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
			givenInput_ExpectThisManyPossibleMolecules(input1,10);
			givenInput_ExpectThisManyPossibleMolecules(input2,4);
		}
		private void givenInput_ExpectThisManyPossibleMolecules(String input, int expected) {
			SingleManipulation n = makeNuclearFusion(input);
			assertEquals(expected, n.getNumberOfPossibleMolecules());
		}
		private void givenInput_ExpectPossibleMolecule(String input, String expected) {
			SingleManipulation n = makeNuclearFusion(input);
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
			Interpreter i = makeInterpreter(input);
			String actual = i.getMolecule().toString();
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
			Interpreter i = makeInterpreter(input);
			List<Replacement> replacements = i.getFusions();
			exists = false;
			for(Replacement r : replacements)
				if (expected.equals(r.toString()))
					exists = true;
			return exists;
		}
	}
}
