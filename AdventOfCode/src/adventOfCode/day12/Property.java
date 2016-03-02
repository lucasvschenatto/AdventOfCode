package adventOfCode.day12;

public class Property implements Element {
	
	@Override
	public int sumAll(Context c) throws RedValueException {
		c.pos = c.jSON.indexOf(":", c.pos)+1;
		return new Value().sumAll(c);
	}

}
