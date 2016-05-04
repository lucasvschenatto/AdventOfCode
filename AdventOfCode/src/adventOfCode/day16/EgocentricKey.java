package adventOfCode.day16;

import java.util.Arrays;
import java.util.List;

class EgocentricKey{
	private List<String> attributes;
	private EgocentricKey(List<String> attributes){
		this.attributes = attributes;
	}
	static EgocentricKey create(String attributes){
		return new EgocentricKey(Arrays.asList(attributes.split(", ")));
	}
	@Override
	public int hashCode(){
		return 0;
	}
	@Override
	public boolean equals(Object other) {
		for (String otherAtr : ((EgocentricKey) other).attributes)
			if(!match(attributes,otherAtr))
				return false;
		return true;
	}
	private boolean match(List<String> hints, String atr) {
		for (String hint : hints) {
			Strategy s = Factory.create(hint);
			if (s.match(atr))
				return true;
		}
		return false;
	}	
}