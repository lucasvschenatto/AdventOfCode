package adventOfCode.day12;

public class Value implements Element {
	@Override
	public int sumAll(Context c) throws RedValueException {
		if(c.jSON.charAt(c.pos)=='[')
			return new JArray().sumAll(c);
		else if(c.jSON.charAt(c.pos)=='{')
			return new JObject().sumAll(c);
		else if (c.jSON.charAt(c.pos)=='"')
			return new JString().sumAll(c);
		else
			return new JNumber().sumAll(c);
	}
}
