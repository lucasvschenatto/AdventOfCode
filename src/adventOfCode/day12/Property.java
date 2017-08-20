package adventOfCode.day12;

public abstract class Property{
	public static int sumAll(Context c) throws RedValueException {
		c.pos = c.jSON.indexOf(":", c.pos)+1;
		return Value.sumAll(c);
	}

}
