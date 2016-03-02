package adventOfCode.day12;

public class JObject implements Element {

	@Override
	public int sumAll(Context c) {
		int sum = 0;
		boolean isRed = false;
		while(c.jSON.charAt(c.pos)!='}'){
			if(c.jSON.charAt(c.pos) == ',')
				c.pos++;
			try {
				sum += new Property().sumAll(c);
			} catch (RedValueException e) {
				isRed = true;
				}
		}
		c.pos++;
		return (isRed)? 0:sum;
	}

}
