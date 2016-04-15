package adventOfCode.day16;

import java.util.HashMap;
import java.util.Map;


public class SueList {
	private Map<DinamicKey,Integer> sues = new HashMap<DinamicKey,Integer>();
	public SueList(String sueList) {
		for(String sue: sueList.split("\n")){
			DinamicKey key = DinamicKey.create(sue.split(": ", 2)[1]);
			Integer number = Integer.valueOf(sue.split("[ :]")[1]);
			sues.put(key, number);
		}
	}

	public int findSue(String hints) {
		return sues.get(DinamicKey.create(hints)).intValue();
	}
}
