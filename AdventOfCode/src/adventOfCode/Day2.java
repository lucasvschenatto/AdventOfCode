package adventOfCode;

public class Day2 implements Challenge{

	public int surfacePacks(String packages) {
		Calculation surface = (h,w,l) ->{
			int area1 = calculateArea(h,w);
			int area2 = calculateArea(h,l);
			int area3 = calculateArea(l,w);
			int surf = (area1+area2+area3)*2;
			int slack = (area1 < area2)? area1:area2;
			slack = (slack < area3)? slack:area3;
			return surf+slack;
		};
		
		return forAll(packages, surface);
	}
	
	public int ribbonPacks(String packages) {
		Calculation ribbon = (h,w,l) -> {
			int area1 = calculatePerimeter(h,w);
			int area2 = calculatePerimeter(h,l);
			int area3 = calculatePerimeter(l,w);
			int smaller = (area1 < area2)? area1:area2;
			smaller = (smaller < area3)? smaller:area3;
			return (smaller*2) + (h*w*l);
		};
		return forAll(packages, ribbon);
	}
	
	private int forAll(String packages, Calculation calc) {
		String[] arrayPackages = packages.split("\n");
		int result = 0;
		for (String pack : arrayPackages) {
			pack = pack.trim();
			int[] dimensions = (pack.isEmpty())? new int[]{0,0,0} : toIntArray(pack);
			result += calc.execute(dimensions[0], dimensions[1], dimensions[2]);
		}
		return result;
		
	}

	private int calculateArea(int w, int h) {
		return w*h;
	}
	private int calculatePerimeter(int w, int h){
		return w+h;
	}
	private int[] toIntArray(String dimensions) {
		String[] as = dimensions.split("x");
		int[] ai = new int[as.length];
		for(int i = 0; i<as.length; i++){
			ai[i] = Integer.valueOf(as[i]);
		}
		return ai;
	}
	private interface Calculation{
		int execute(int heigth, int width, int lenght);
	}
	
	@Override
	public String part1(String input) {
		return String.valueOf(surfacePacks(input));
	}
	@Override
	public String part2(String input) {
		return String.valueOf(ribbonPacks(input));
	}
}

