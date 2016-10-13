package adventOfCode;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

import adventOfCode.day22.*;

public class Day22Test {
	private static final int POISON = 173;
	public static int MISSILE = 53;
	public static int DRAIN = 73;
	public static int SHIELD = 113;
	private Wizard wizard;
	private Boss boss;
	Battle battle;

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
		int mana = SHIELD+MISSILE*4+SHIELD+MISSILE;
		givenWizard(7,mana);
		givenBoss(20,8);
		whenFight();
		manaSpentToWinIs(mana);
	}
	
	@Test
	public void manaSteps(){
		stepIs(1,MISSILE);
		stepIs(2,DRAIN);
		stepIs(3,MISSILE*2);
	}
	
	private void stepIs(int count, int expected) {
		ManaStep m = new ManaStep();
		int actual = 0;
		for(int i = 1; i<= count; i++)
			actual = m.next();
		assertThat(actual,equalTo(expected));
	}

	@Test@Ignore
	public void minimumDamageInWizardIsOne(){
		int mana = SHIELD+MISSILE*4+SHIELD+MISSILE;
		givenWizard(7,mana);
		givenBoss(20,7);
		whenFight();
		manaSpentToWinIs(mana);
	}

	@Test@Ignore
	public void poison(){
		int mana = POISON+MISSILE;
		givenWizard(2,mana);
		givenBoss(10,1);
		whenFight();
		manaSpentToWinIs(mana);
	}

	private void manaSpentToWinIs(int expected) {
		assertThat(battle.manaSpent(),equalTo(expected));
	}

	private void whenFight() {
		battle = new Battle(wizard,boss);
	}

	private void givenBoss(int health, int damage) {
		boss = new Boss(health,damage);
		
	}

	private void givenWizard(int health, int mana) {
		wizard = new Wizard(health,mana);
	}
}
