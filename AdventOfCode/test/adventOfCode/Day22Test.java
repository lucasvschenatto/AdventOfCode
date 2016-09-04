package adventOfCode;

import static org.junit.Assert.*;

import org.junit.*;

import adventOfCode.day22.*;

public class Day22Test {
	public static abstract class SpellTest{
		public abstract Spell makeSpell();
		protected abstract int expectedCost();
		protected abstract int expectedTurns();
		protected abstract int expectedDamage();
		protected abstract int expectedHeal();
		protected abstract int expectedArmor();
		protected abstract int expectedMana();
		@Test
		public void expectsCost(){assertEquals(expectedCost(),makeSpell().getCost());}
		@Test
		public void expectsTurns(){assertEquals(expectedTurns(),makeSpell().getTurns());}
		@Test
		public void expectsDamage(){assertEquals(expectedDamage(),makeSpell().getDamage());}
		@Test
		public void expectsHeal(){assertEquals(expectedHeal(),makeSpell().getHeal());}
		@Test
		public void expectsArmor(){assertEquals(expectedArmor(),makeSpell().getArmor());}
		@Test
		public void expectsMana(){assertEquals(expectedMana(),makeSpell().getMana());}
	}
	public static class MagicMissileTest extends SpellTest{
		public Spell makeSpell()       {return new MagicMissile();}
		protected int expectedCost()   {return 53;}
		protected int expectedTurns()  {return 0;}
		protected int expectedDamage() {return 4;}
		protected int expectedHeal()   {return 0;}
		protected int expectedArmor()  {return 0;}
		protected int expectedMana()   {return 0;}
	}
	public static class DrainTest extends SpellTest{
		public Spell makeSpell()       {return new Drain();}
		protected int expectedCost()   {return 73;}
		protected int expectedTurns()  {return 0;}
		protected int expectedDamage() {return 2;}
		protected int expectedHeal()   {return 2;}
		protected int expectedArmor()  {return 0;}
		protected int expectedMana()   {return 0;}
	}
	public static class ShieldTest extends SpellTest{
		public Spell makeSpell()       {return new Shield();}
		protected int expectedCost()   {return 113;}
		protected int expectedTurns()  {return 6;}
		protected int expectedDamage() {return 0;}
		protected int expectedHeal()   {return 0;}
		protected int expectedArmor()  {return 7;}
		protected int expectedMana()   {return 0;}
	}
	public static class PoisonTest extends SpellTest{
		public Spell makeSpell()       {return new Poison();}
		protected int expectedCost()   {return 173;}
		protected int expectedTurns()  {return 6;}
		protected int expectedDamage() {return 3;}
		protected int expectedHeal()   {return 0;}
		protected int expectedArmor()  {return 0;}
		protected int expectedMana()   {return 0;}
	}
	public static class RechargeTest extends SpellTest{
		public Spell makeSpell()       {return new Recharge();}
		protected int expectedCost()   {return 229;}
		protected int expectedTurns()  {return 5;}
		protected int expectedDamage() {return 0;}
		protected int expectedHeal()   {return 0;}
		protected int expectedArmor()  {return 0;}
		protected int expectedMana()   {return 101;}
	}
	public abstract static class WarriorTest{
		protected abstract CharacterRole makeRole(int hitPoints,int damage,int armor);
		@Test
		public void defenseReducesHitPoints(){
			CharacterRole w = makeRole(50,5,3);
			w.defend(10);
			assertEquals(43,w.getHitPoints());
		}
		@Test
		public void defenseReducesAtLeastOnePoint(){
			CharacterRole w = makeRole(100,5,999);
			w.defend(3);
			assertEquals(99,w.getHitPoints());
		}
		@Test
		public void attackReducesEnemysHitPoints(){
			CharacterRole attacker = makeRole(100,15,0);
			CharacterRole enemy    = makeRole(100,0,4);
			attacker.attack(enemy);
			assertEquals(100,attacker.getHitPoints());
			assertEquals(89, enemy.getHitPoints());
		}
		@Test
		public void sameDamageAndArmor_ButDifferentHitPoints_IsEqual(){
			CharacterRole w1  = makeRole(100,13,2);
			CharacterRole w2 = makeRole(999,13,2);
			assertEquals(w1,w2);
		}
	}
	
	public static class BossTest extends WarriorTest{
		protected CharacterRole makeRole(int hitPoints,int damage, int armor){
			return makeBoss(hitPoints,damage,armor);
		}
		public static Boss makeBoss(int hitPoints,int damage, int armor){
			return new Boss(hitPoints,damage,armor);
		}
		@Test
		public void givenBoss_ItHas_HitPoints_Damage_Armor(){
			Boss b = makeBoss(100,9,3);
			assertEquals(100,b.getHitPoints());
			assertEquals(9,b.getDamage());
			assertEquals(3,b.getArmor());
		}
	}

	public static class WizardTest extends WarriorTest{
		protected CharacterRole makeRole(int hitPoints,int damage,int armor){
			Spell s = new SpySpell(damage);
			return makeWizard(hitPoints,500,armor, s);
		}
		private Wizard makeWizard(int hitPoints,int mana,int armor, Spell spell){
			return new Wizard(hitPoints,mana, armor, spell);
		}
		public static Wizard makeWizard(int hitPoints, int mana, int armor){
			return new Wizard(hitPoints,mana,armor, new SpySpell(10));
		}
		@Test
		public void wizardHasHitPoints(){
			Wizard p = makeWizard(100,50,70);
			assertEquals(100,p.getHitPoints());
		}
//		@Test
//		public void givenWeaponAndRing_DamageIsTheSumOfBoth(){
//			Item w = new Weapon("Dagger",4,0);
//			Item r = new Ring("Damage +1",1,0);
//			Wizard p = makeWizard(100,w,r);
//			assertEquals(5,p.getDamage());
//		}
//		@Test
//		public void givenArmorAndRing_DamageIsTheSumOfBoth(){
//			Item a = new Armor("Chainmail",0,2);
//			Item r = new Ring("Armor +1",0,1);
//			Wizard p = makeWizard(100,a,r);
//			assertEquals(3,p.getArmor());
//		}
	}
	
	public static class BattleTest{
		SpyRole spy1;
		SpyRole spy2;
		private void givenSpy1(int hit, int damage, int armor){
			spy1 = new SpyRole(hit,damage,armor);
		}
		private void givenSpy2( int hit, int damage, int armor){
			spy2 = new SpyRole(hit,damage,armor);
		}
		private void whenFight(){
			new Battle(spy1,spy2).fight();
		}
		private void expectsAttacks(int attack1, int attack2){
			assertEquals(attack1,spy1.getAttacks());
			assertEquals(attack1,spy2.getDefenses());
			assertEquals(attack2,spy2.getAttacks());
			assertEquals(attack2,spy1.getDefenses());
		}
		@Before
		public void setup(){
			spy1 = null;
			spy2 = null;
		}
		@Test
		public void oneTurnGameIsOneAttack(){
			givenSpy1(100,10,0);
			givenSpy2(10,1,0);
			whenFight();
			expectsAttacks(1,0);
		}
		@Test
		public void twoTurnsGameIsOneAttackEachPlayer(){
			givenSpy1(100,10,0);
			givenSpy2(10,100,1);
			whenFight();
			expectsAttacks(1,1);
		}
		@Test
		public void manyTurns(){
			givenSpy1(101,10,1);
			givenSpy2(100,10,1);
			whenFight();
			expectsAttacks(12,11);
		}
		@Test
		public void winner(){
			CharacterRole player = WizardTest.makeWizard(100,15,3);
			CharacterRole boss = BossTest.makeBoss(100,9,2);
			Battle b = new Battle(player,boss);

			assertEquals(player,b.getWinner());
		}
		@Test
		public void doesntChangeOriginalObject(){
			CharacterRole player = WizardTest.makeWizard(100,3,4);
			CharacterRole boss = BossTest.makeBoss(100,9,2);
			Battle b = new Battle(player,boss);
			b.fight();
			assertEquals(100,player.getHitPoints());
		}
	}
//	public static class StrategistTest{
//		@Test
//		public void findWinningScenario(){
//			givenPlyerHitPoints_AndBoss_ItNeeds(100,new Boss(100,0,0),8);
//			givenPlyerHitPoints_AndBoss_ItNeeds(8,new Boss(12,7,2),65);
//		}
//
//		private void givenPlyerHitPoints_AndBoss_ItNeeds(int pHitPoints, Boss boss,int expectedGold) {
//			Strategist s = new Strategist(pHitPoints, boss);
//			Wizard warrior = new Wizard(pHitPoints,s.getItems());
//			Battle b = new Battle(warrior,boss);
//			
//			assertEquals(warrior,b.getWinner());
//			assertEquals(Arrays.toString(s.getItems()),expectedGold,s.getLeastGold());
//		}
//	}
//	public static class SolverTest{
//		@Test
//		public void readBoss(){
//			expectsBossFor(new Boss(104,8,1),"Hit Points: 104\n"+"Damage: 8\n"+"Armor: 1");
//			expectsBossFor(new Boss(10,3,2),"Hit Points: 10\n"+"Damage: 3\n"+"Armor: 2");
//		}
//		@Test
//		public void leastAmountOfGoldFor(){
//			leastForIs(100,"Hit Points: 104\n"+"Damage: 8\n"+"Armor: 1",78);
//		}
//		@Test
//		public void mostAmountOfGoldFor(){
//			mostForIs(100,"Hit Points: 104\n"+"Damage: 8\n"+"Armor: 1",148);
//		}
//		private void mostForIs(int playerH, String input, int expected) {
//			Solver s = new Solver(playerH,input);
//			assertEquals(expected,s.mostGoldNeeded());
//		}
//		private void leastForIs(int playerH, String input, int expected) {
//			Solver s = new Solver(playerH,input);
//			assertEquals(expected,s.leastGoldNeeded());
//			
//		}
//		private void expectsBossFor(Boss expected, String input) {
//			Solver s = new Solver(100,input);
//			assertEquals(expected,s.getBoss());
//		}
//	}
}
