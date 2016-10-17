package adventOfCode;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

import adventOfCode.day22.*;

public class Day22Test {
	private static final int MISSILE  = 53;
	private static final int DRAIN    = 73;
	private static final int SHIELD   = 113;
	private static final int POISON   = 173;
	private static final int RECHARGE = 229;
	private Wizard wizard;
	private Boss boss;
	Strategist strategist;

	@Test
	public void magicMissile(){
		int mana = MISSILE;
		givenWizard(1,mana);
		givenBoss(4,1);
		whenFight();
		manaSpentToWinIs(mana);
		
		mana = MISSILE*2;
		givenWizard(2,mana);
		givenBoss(8,1);
		whenFight();
		manaSpentToWinIs(mana);
	}
	
	@Test
	public void drain(){
		int mana = DRAIN+MISSILE;
		givenWizard(1,mana);
		givenBoss(6,1);
		whenFight();
		manaSpentToWinIs(mana);
		
		mana = DRAIN*2+MISSILE;
		givenWizard(1,mana);
		givenBoss(7,2);
		whenFight();
		manaSpentToWinIs(mana);
	}
	
	@Test
	public void shield(){
		int mana = SHIELD+MISSILE*2;
		givenWizard(3,mana);
		givenBoss(8,8);
		whenFight();
		manaSpentToWinIs(mana);
	}
	
	@Test
	public void shieldLasts6Turns(){
		int mana = SHIELD+POISON+MISSILE*2;
		givenWizard(7,mana);
		givenBoss(20,8);
		whenFight();
		manaSpentToWinIs(mana);
	}
	
	@Test
	public void FindOptimalSolution(){
		int mana = SHIELD+POISON+MISSILE*2;
		givenWizard(7,mana);
		givenBoss(20,7);
		whenFight();
		manaSpentToWinIs(mana);
	}

	@Test
	public void poison(){
		int mana = POISON+MISSILE;
		givenWizard(2,mana);
		givenBoss(11,1);
		whenFight();
		manaSpentToWinIs(mana);
	}
	
	@Test
	public void recharge(){
		int mana = RECHARGE+MISSILE*2+POISON+MISSILE*3;
		givenWizard(11,RECHARGE);
		givenBoss(36,1);
		whenFight();
		manaSpentToWinIs(mana);
	}
	
	@Test
	public void acceptance1(){
		int mana = RECHARGE+SHIELD+DRAIN+POISON+MISSILE;
		givenWizard(10,250);
		givenBoss(14,8);
		whenFight();
		manaSpentToWinIs(mana);
	}
	
	@Test
	public void acceptance2(){
		int mana = POISON+MISSILE;
		givenWizard(10,250);
		givenBoss(13,8);
		whenFight();
		manaSpentToWinIs(mana);
	}
	
	@Test
	public void acceptancePart1(){
		givenWizard(50,500);
		givenBoss(71,10);
		whenFight();
		manaSpentToWinIs(1824);
	}
	
	@Test@Ignore
	public void acceptancePart2(){
		givenWizard(50,500);
		givenBoss(71,10);
		whenFight();
		manaSpentToWinIs(1937);
	}

	private void manaSpentToWinIs(int expected) {
		int actual = strategist.leastManaNeeded();
		assertThat(strategist.bestWayFound(),actual,equalTo(expected));
	}

	private void whenFight() {
		strategist = new Strategist(wizard,boss);
	}

	private void givenBoss(int health, int damage) {
		boss = new Boss(health,damage);
		
	}

	private void givenWizard(int health, int mana) {
		wizard = new Wizard(health,mana);
	}
}
