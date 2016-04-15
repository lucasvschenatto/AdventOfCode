package adventOfCode.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DinamicKey{
	private List<String> attributes;
	private boolean lastMatch;
	private DinamicKey(List<String> attributes){
		this.attributes = new ArrayList<String>(attributes);
	}
	static DinamicKey create(String attributes){
		return new DinamicKey(Arrays.asList(attributes.split(", ")));
	}
	@Override
	public boolean equals(Object other) {
		Factory f = new Factory(this);
		for (String atr : ((DinamicKey) other).attributes)
			attributes.forEach((String hint)-> {
				Strategy s = f.create(hint);
				s.match(atr);
			});
//			if (!attributes.contains(atr))
//				return false;
		return lastMatch;
	}
	@Override
	public int hashCode(){
		return 0;
	}
	public void setLastMatch(boolean lastMatch) {
		if(this.lastMatch != false)
			this.lastMatch = lastMatch;
	}
}