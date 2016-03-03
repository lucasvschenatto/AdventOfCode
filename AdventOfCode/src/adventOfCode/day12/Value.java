package adventOfCode.day12;

public abstract class Value{

	public static int sumAll(Context c) throws RedValueException {
		if(c.jSON.charAt(c.pos)=='['){
			c.pos++;
			return JArray.sumAll(c);
		}
		else if(c.jSON.charAt(c.pos)=='{')
		{
			c.pos++;
			return JObject.sumAll(c);
		}
		else if (c.jSON.charAt(c.pos)=='"'){
			c.pos++;
			return JString.sumAll(c);
		}
		else
			return JNumber.sumAll(c);
	}
}
