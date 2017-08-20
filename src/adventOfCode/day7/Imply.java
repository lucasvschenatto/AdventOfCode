package adventOfCode.day7;

public class Imply implements Source{
	private String input;
	public Imply(String input){
		this.input = input;
	}
	public int run(){
		return getValue(input);
	}
}