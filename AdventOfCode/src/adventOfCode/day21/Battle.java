package adventOfCode.day21;

public class Battle {

	private CharacterRole player1;
	private CharacterRole player2;
	private CharacterRole winner;
	private boolean over;

	public Battle(CharacterRole player1, CharacterRole player2) {
		this.player1 = player1.clone();
		this.player2 = player2.clone();
	}

	public void fight() {
		CharacterRole attacker = player1;
		CharacterRole defender = player2;
		boolean gameOver = false;
		while(!gameOver){
			attacker.attack(defender);
			if(defender.getHitPoints() <= 0){
				gameOver = true;
				winner = attacker;
			}
			else{
				CharacterRole changed = attacker;
				attacker = defender;
				defender = changed;
			}
		}
	}

	public CharacterRole getWinner() {
		if(!over)
			fight();
		return winner;
	}

}
