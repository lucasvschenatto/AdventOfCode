package adventOfCode.day7;

import adventOfCode.Day7;

public interface Source{
	static final int MASK = (1 << 16) -1;
	public int run();
	default int getValue(String input){
		try{
			return Integer.valueOf(input);}
		catch (NumberFormatException e){
			for (Wire wire : Day7.getInstance().getWires())
				if(wire.getName().equals(input))
					return wire.getSignal();
		}
		return 0;
	}
}