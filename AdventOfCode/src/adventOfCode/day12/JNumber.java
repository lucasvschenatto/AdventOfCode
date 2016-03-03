package adventOfCode.day12;

public class JNumber{

	public static int sumAll(Context c) {
		int start = c.pos;
		if(c.jSON.charAt(c.pos)=='-')
			c.pos++;
		while(Character.isDigit(c.jSON.charAt(c.pos))){
			c.pos++;
		}
		int end = c.pos;
		int number = Integer.valueOf(c.jSON.substring(start, end));
		return number;
	}

}
