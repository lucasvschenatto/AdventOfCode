package adventOfCode.day12;

public abstract class JArray{

	static public int sumAll(Context c) {
		int sum = 0;
		while(c.jSON.charAt(c.pos)!=']'){
			if(c.jSON.charAt(c.pos) == ',')
				c.pos++;
			try {
				sum += Value.sumAll(c);
			}catch(RedValueException e){}
		}
		c.pos++;
		return sum;
	}

}
