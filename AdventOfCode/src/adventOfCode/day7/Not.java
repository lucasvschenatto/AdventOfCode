package adventOfCode.day7;

public class Not implements Source{
	private String input;
	public Not(String input){
		this.input = input;
	}
	public int run(){
		return ~ getValue(input) & MASK;
	}
}