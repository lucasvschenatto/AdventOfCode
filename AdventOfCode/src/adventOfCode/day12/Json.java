package adventOfCode.day12;

public class Json{
	private Context c;
	public Json(String jSON){
		c = new Context(jSON, false);
	}
	public Json(String jSON, boolean nonReds){
		c = new Context(jSON, nonReds);
	}
	
	public int sumAll() {
		int sum = 0;
		while(c.pos< c.jSON.length()){
			if(c.jSON.charAt(c.pos)=='['){
				c.pos++;
				sum += JArray.sumAll(c);
			}
			else if (c.jSON.charAt(c.pos)=='{'){
				c.pos++;
				sum += JObject.sumAll(c);
			}
			else
				c.pos++;
		}
		return sum;
	}

}
