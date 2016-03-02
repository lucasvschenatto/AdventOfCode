package adventOfCode.day12;

public class JNumber implements Element {

	@Override
	public int sumAll(Context c) {
		int start = c.pos;
		while(Character.isDigit(c.jSON.charAt(c.pos))){
			c.pos++;
		}
		int end = c.pos;
		int number = Integer.valueOf(c.jSON.substring(start, end));
		return number;
	}

}
