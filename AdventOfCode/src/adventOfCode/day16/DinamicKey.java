package adventOfCode.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DinamicKey{
	private List<String> attributes;
	private DinamicKey(List<String> attributes){
		this.attributes = new ArrayList<String>(attributes);
	}
	static DinamicKey create(String attributes){
		return new DinamicKey(Arrays.asList(attributes.split(", ")));
	}
	@Override
	public int hashCode(){
		return 0;
	}
	@Override
	public boolean equals(Object other) {
		for (String atr : ((DinamicKey) other).attributes)
			if(!match(attributes,atr))
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