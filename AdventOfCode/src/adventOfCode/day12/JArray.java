package adventOfCode.day12;

public class JArray implements Element {

	@Override
	public int sumAll(Context c) {
		int sum = 0;
		while(c.jSON.charAt(c.pos)!=']'){
			char current = c.jSON.charAt(c.pos);
			c.pos++;
			if(current == '['){
				sum += new JArray().sumAll(c);
			}else if(current == '{')
				sum += new JObject().sumAll(c);
			else if(current == ',')
				c.pos++;
			else
				try {
					c.pos++;
					sum += new Value().sumAll(c);
				} catch (RedValueException e) {
					;
				}
		}
		c.pos++;
		return sum;
	}

}
