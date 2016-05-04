package adventOfCode.day16;

import java.util.HashMap;
import java.util.Map;


public class SueList {
	private Map<EgocentricKey,Integer> sues = new HashMap<EgocentricKey,Integer>();
	public SueList(String sueList) {
		readSues(sueList);
	}

	private void readSues(String sueList) {
		for(String sue: sueList.split("\n")){
			EgocentricKey key = EgocentricKey.create(sue.split(": ", 2)[1]);
			Integer number = Integer.valueOf(sue.split("[ :]")[1]);
			sues.put(key, number);
		}
	}

	public int findSue(String hints) {
		return sues.get(EgocentricKey.create(hints)).intValue();
	}
}
