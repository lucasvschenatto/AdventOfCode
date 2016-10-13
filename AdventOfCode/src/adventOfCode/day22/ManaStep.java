package adventOfCode.day22;

public class ManaStep {
	private int[] spells = {53,73,113,173,229};
	private int current;
	public ManaStep(){
		this.current = 0;
	}
	public int next() {
		if(current == 0)
			current = spells[0];
		else
			current = spells[1];
		return current;
	}

}
