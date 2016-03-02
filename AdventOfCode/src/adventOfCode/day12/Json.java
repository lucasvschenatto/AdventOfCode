package adventOfCode.day12;

public class Json{
	
	public int sumAll(String jSON) {
		Context c = new Context(jSON, 0);
		int sum = 0;
		while(c.pos< jSON.length()){
			if(jSON.charAt(c.pos)=='['){
				c.pos++;
				sum += new JArray().sumAll(c);
			}
			else if (jSON.charAt(c.pos)=='['){
				c.pos++;
				sum += new JObject().sumAll(c);
			}
			else
				c.pos++;
		}
		return sum;
	}

}
