package adventOfCode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.*;

import adventOfCode.day20.Agency;
import adventOfCode.day20.CommonDivisor;
import adventOfCode.day20.Elves;
import adventOfCode.day20.Delivery;
import adventOfCode.day20.ElevenPresentsAgency;
import adventOfCode.day20.ElevenPresentsElvesFactory;
import adventOfCode.day20.FiftyHousesElves;
import adventOfCode.day20.TenPresentsElvesFactory;

public class Day20Test {

	@Test
	public void commonDivisorTest() {
		commonDivisorFor(1 , Arrays.asList(1));
		commonDivisorFor(2 , Arrays.asList(1,2));
		commonDivisorFor(3 , Arrays.asList(1,3));
		commonDivisorFor(4 , Arrays.asList(1,2,4));
		commonDivisorFor(5 , Arrays.asList(1,5));
		commonDivisorFor(6 , Arrays.asList(1,2,3,6));
		commonDivisorFor(7 , Arrays.asList(1,7));
		commonDivisorFor(8 , Arrays.asList(1,2,4,8));
		commonDivisorFor(9 , Arrays.asList(1,3,9));
	}
	
	@Test
	public void deliveryTest(){
		houseReceivesPresents(1,10 );
		houseReceivesPresents(2,30 );
		houseReceivesPresents(3,40 );
		houseReceivesPresents(4,70 );
		houseReceivesPresents(5,60 );
		houseReceivesPresents(6,120);
		houseReceivesPresents(7,80 );
		houseReceivesPresents(8,150);
		houseReceivesPresents(9,130);
	}

	@Test
	public void minimumHousesToDeliverPresentsTest(){
		minimumHousesToDeliverPresents(1,1);
		minimumHousesToDeliverPresents(1,10);
		minimumHousesToDeliverPresents(2,11);
		minimumHousesToDeliverPresents(12,200);
	}

	@Test
	public void fiftyHousesElvesTest() {
		houseIsVisitedByNewElves(1,Arrays.asList(1));
		houseIsVisitedByNewElves(50,Arrays.asList(1,2,5,10,25,50));
		houseIsVisitedByNewElves(51,Arrays.asList(3,17,51));
		houseIsVisitedByNewElves(52,Arrays.asList(2,4,13,26,52));
		houseIsVisitedByNewElves(100,Arrays.asList(2,4,5,10,20,25,50,100));
		houseIsVisitedByNewElves(101,Arrays.asList(101));
		houseIsVisitedByNewElves(102,Arrays.asList(3,6,17,34,51,102));
		houseIsVisitedByNewElves(150,Arrays.asList(3,5,6,10,15,25,30,50,75,150));
	}
	@Test
	public void elevenPresentsDelivery(){
		houseReceivesFromElevenPresentsElvs(1,11 );
		houseReceivesFromElevenPresentsElvs(2,33 );
		houseReceivesFromElevenPresentsElvs(4,77 );
		houseReceivesFromElevenPresentsElvs(5,66 );
		houseReceivesFromElevenPresentsElvs(6,132);
		houseReceivesFromElevenPresentsElvs(7,88 );
		houseReceivesFromElevenPresentsElvs(8,165);
		houseReceivesFromElevenPresentsElvs(9,143);
		houseReceivesFromElevenPresentsElvs(50, 11 * (1+2+5+10+25+50) );
		houseReceivesFromElevenPresentsElvs(51, 11 * (3+17+51) );
		houseReceivesFromElevenPresentsElvs(52, 11 * (2+4+13+26+52) );
	}
	@Test
	public void elevenPresentsMinimumHousesToDeliverPresents(){
		elevenPresentsMinimumHousesToDeliverPresents(1,1);
		elevenPresentsMinimumHousesToDeliverPresents(1,11);
		elevenPresentsMinimumHousesToDeliverPresents(2,12);
		elevenPresentsMinimumHousesToDeliverPresents(12,200);
	}
	
	
	private void houseReceivesFromElevenPresentsElvs(int houses, int expected) {
		Delivery d = new Delivery(houses,11, new ElevenPresentsElvesFactory());
		assertEquals(expected, d.getPresents());
	}

	private void houseIsVisitedByNewElves(int house, List<Integer> expected) {
		FiftyHousesElves f = new FiftyHousesElves(house);
		List<Integer>actual = f.getResult();
		actual.sort(null);
		expected.sort(null);
		assertEquals(expected,actual);
	}

	private void minimumHousesToDeliverPresents(int expected, int presents) {
		Agency a = new Agency(presents);
		assertEquals(expected, a.getHouseReceivingAtLeast());
	}
	
	private void elevenPresentsMinimumHousesToDeliverPresents(int expected, int presents) {
		Agency a = new ElevenPresentsAgency(presents);
		assertEquals(expected, a.getHouseReceivingAtLeast());
	}

	private void houseReceivesPresents(int house, int expected) {
		Delivery d = new Delivery(house,10, new TenPresentsElvesFactory());
		assertEquals(expected, d.getPresents());
	}

	private void commonDivisorFor(int input, List<Integer> expected) {
		CommonDivisor c = new Elves(input);
		List<Integer> actual = c.getResult();
		actual.sort(null);
		expected.sort(null);
		assertEquals(expected , actual);
	}

}
