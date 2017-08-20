package adventOfCode.day12;

public class Context {
	String jSON;
	boolean nonReds;
	int pos;
	Context(String jSON, boolean nonReds){
		this.jSON = jSON;
		this.pos = 0;
		this.nonReds = nonReds;
	}
}
