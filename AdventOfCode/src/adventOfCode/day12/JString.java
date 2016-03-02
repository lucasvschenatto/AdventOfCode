package adventOfCode.day12;

public class JString implements Element {

	@Override
	public int sumAll(Context c) throws RedValueException {
		int start = c.pos;
		do{
			c.pos++;
		}while(c.jSON.charAt(c.pos)!='"');
		c.pos++;
		int end = c.pos;
		String s = c.jSON.substring(start, end);
		if(s.equals("red"))
			throw new RedValueException();
		return 0;
	}

}
