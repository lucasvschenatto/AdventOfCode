package adventOfCode.day23;

public class Computer {
	private int a;
	private int b;
	protected Computer(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void run(String program) {
		for(String line : program.split("\n")){
			if(line.contains("hlf"))
				if(line.contains("a"))
					a = a/2;
				else
					b = b/2;
			else if(line.contains("tpl"))
				if(line.contains("a"))
					a = a*3;
				else
					b = b*3;
			else if(line.contains("inc"))
				if(line.contains("a"))
					a++;
				else
					b++;
		}
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

}
