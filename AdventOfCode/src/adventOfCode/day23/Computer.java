package adventOfCode.day23;

public class Computer {
	private int a;
	private int b;
	public Computer(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void run(String program) {
		String [] instructions = program.split("\n");
		int index = 0;
		while(index < instructions.length){
			calculateValues(instructions[index]);			
			index += offset(instructions[index]);
		}
	}

	private void calculateValues(String line) {
		if(line.contains("hlf")){
			if(line.contains("a"))
				a = a/2;
			else if(line.contains("b"))
				b = b/2;
		}
		else if(line.contains("tpl")){
			if(line.contains("a"))
				a = a*3;
			else if(line.contains("b"))
				b = b*3;
		}
		else if(line.contains("inc")){
			if(line.contains("a"))
				a++;
			else if(line.contains("b"))
				b++;
		}
	}

	private int offset(String line) {
		if(line.contains("jmp")){
			return Integer.valueOf(line.split(" ")[1]);
		}
		else if(line.contains("jie")){
			if(line.contains("a") && isAEven())
				return Integer.valueOf(line.split(" ")[2]);
			else if(line.contains("b") && isBEven())
				return Integer.valueOf(line.split(" ")[2]);			
		}
		else if(line.contains("jio")){
			if(line.contains("a") && a == 1)
				return Integer.valueOf(line.split(" ")[2]);
			else if(line.contains("b") && b == 1)
				return Integer.valueOf(line.split(" ")[2]);			
		}
		return 1;
	}

	private boolean isAEven() {
		return (a & 1) == 0;
	}
	private boolean isBEven() {
		return (b & 1) == 0;
	}
	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

}
