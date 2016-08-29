package adventOfCode.day21;

public class Battle {

	private Warrior player1;
	private Warrior player2;
	private Warrior winner;
	private boolean over;

	public Battle(Warrior player1, Warrior player2) {
		this.player1 = player1.clone();
		this.player2 = player2.clone();
	}

	public void fight() {
		Warrior attacker = player1;
		Warrior defender = player2;
		boolean gameOver = false;
		while(!gameOver){
			attacker.attack(defender);
			if(defender.getHitPoints() <= 0){
				gameOver = true;
				winner = attacker;
			}
			else{
				Warrior changed = attacker;
				attacker = defender;
				defender = changed;
			}
		}
	}

	public Warrior getWinner() {
		if(!over)
			fight();
		return winner;
	}

}
