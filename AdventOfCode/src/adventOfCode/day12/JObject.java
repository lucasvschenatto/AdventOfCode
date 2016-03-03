package adventOfCode.day12;

public abstract class JObject{
	public static int sumAll(Context c) {
		int sum = 0;
		boolean discard = false;
		while(c.jSON.charAt(c.pos)!='}'){
			if(c.jSON.charAt(c.pos) == ',')
				c.pos++;
			try {
				sum += Property.sumAll(c);
			}catch (RedValueException e){
				if(c.nonReds)
					discard = true;}
		}
		c.pos++;
		return (discard)? 0:sum;
	}

}
