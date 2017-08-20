package adventOfCode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import org.junit.*;
import adventOfCode.day24.*;

public class Day24Test {
	private Divider divider;

	@Test
	public void weightIsEven(){
		given(1);			whenDividedBy(1);	thenEachWeightIs(1);
		given(1,2,3);		whenDividedBy(2);	thenEachWeightIs(3);
		given(1,2,2,3,4);	whenDividedBy(3);	thenEachWeightIs(4);
	}
	
	@Test
	public void eachGroupHasBalancedWeight(){
		given(1,2,3);		whenDividedBy(2);	firstIs(3); secondIs(2,1);
		given(1,2,2,3,4);	whenDividedBy(3);	firstIs(4); secondIs(3,1); thirdIs(2,2);
	}
	
	@Test
	public void leastEntanglement(){
		given(1,2,3,4,5,6,7,8,9);
		whenDividedBy(3);
		firstIs(9,6);
		secondIs(8,7);
	}
	
	@Test
	public void acceptanceTest(){
		given(1,2,2,3,4,5,7,8,9,10,11);
		whenDividedBy(3);
		firstIs(11,9);
		secondIs(10,8,2);
		thirdIs(7,5,4,3,1);
	}

	private void firstIs(int ...exp) {
		assertGroup(0,exp);
	}
	
	private void secondIs(int ...exp) {
		assertGroup(1,exp);
	}
	
	private void thirdIs(int ...exp) {
		assertGroup(2,exp);
	}

	private void assertGroup(int group,int... exp) {
		List<Integer> expected = listFrom(exp);
		assertThat(divider.getGroup(group), equalTo(expected));
	}

	private List<Integer> listFrom(int... exp) {
		@SuppressWarnings("serial")
		List<Integer>  expected = new ArrayList<Integer>() {{ for (int i : exp) add(i); }};
		return expected;
	}

	private void thenEachWeightIs(int expected) {
		assertThat(divider.getBalanceWeight(), equalTo(expected));
	}

	private void whenDividedBy(int groups) {
		divider.splitIn(groups);
	}

	private void given(int ...pack) {
		List<Integer> packages = listFrom(pack);
		divider = new Divider(packages);
	}
}
