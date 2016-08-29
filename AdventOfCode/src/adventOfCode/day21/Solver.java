package adventOfCode.day21;

public class Solver {

	private Boss boss;
	private int playerHitPoints;

	public Solver(int playerHitPoints, String inputBoss) {
		Interpreter bossStats = new Interpreter(inputBoss);
		this.playerHitPoints = playerHitPoints;
		this.boss = new Boss(bossStats.hitPoints,bossStats.damage,bossStats.armor);
	}

	public Boss getBoss() {
		return boss;
	}
	
	class Interpreter{
		int hitPoints;
		int damage;
		int armor;
		Interpreter(String input){
			for(String stat: input.split("\n")){
				if(stat.contains("Hit Points"))
					loadHitPoints(stat);
				else if(stat.contains("Damage"))
					loadDamage(stat);
				else
					loadArmor(stat);
			}
		}
		private void loadHitPoints(String stat) {
			this.hitPoints = filterValue(stat);
		}
		private void loadDamage(String stat) {
			this.damage = filterValue(stat);
		}
		private void loadArmor(String stat) {
			this.armor = filterValue(stat);
		}
		private int filterValue(String stat) {
			String[] parts = stat.split(" ");
			return Integer.valueOf(parts[parts.length-1]);
		}
	}

	public int leastGoldNeeded() {
		Strategist s = new Strategist(playerHitPoints, boss);
		return s.getGold();
	}
}
