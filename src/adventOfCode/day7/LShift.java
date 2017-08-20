package adventOfCode.day7;

public class LShift implements Source{
	private String input1, input2;
	public LShift(String input1,String input2){
		this.input1 = input1;
		this.input2 = input2;
	}
	public int run(){
		return (getValue(input1)&MASK) << (getValue(input2)&MASK);
	}
}