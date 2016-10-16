package adventOfCode.day22;

public class Strategist {
	
	private Wizard wizard;
	private Boss boss;
	private Battle battle;
	private String bestWayFound;

	public Strategist(Wizard wizard, Boss boss) {
		this.wizard = wizard;
		this.boss = boss;
		battle = new Battle(wizard,boss);
	}

	public int leastManaNeeded() {
		int mana = battle.getManaSpent();
		bestWayFound = battle.describeHistory();
		for(int i = mana-1; i>=53;i = mana - 1){
			battle = new Battle(wizard,boss,mana-1);
			if (battle.wizardWin()){
				mana = battle.getManaSpent();
				bestWayFound = battle.describeHistory();
			}
			else return mana;
		}
		return mana;
	}
	public String bestWayFound(){
		return bestWayFound;
	}
}
