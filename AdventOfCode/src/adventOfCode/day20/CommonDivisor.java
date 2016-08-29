package adventOfCode.day20;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonDivisor {
	protected final int input;
	
	public CommonDivisor(int input) {
		this.input = input;
	}
	
	protected abstract int getMinimumElveNumber();

	public List<Integer> getResult() {
		List<Integer> result = new ArrayList<Integer>();
		result.add(Integer.valueOf(input));
		for(int i = getMinimumElveNumber(); i<(input/2)+1;i++)
			if(input % i == 0)
				result.add(Integer.valueOf(i));
		return result;
	}

}