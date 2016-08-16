package adventOfCode.day19;

public abstract class Replacement {
	public final static String SEPARATOR = " => ";
	public final String from;
	public final String to;

	public Replacement(String from, String to){
		this.from = from;
		this.to = to;
	}
	
	public String toString(){
		return from + SEPARATOR + to;
	}
	
	public boolean equals(Object other){
		return other instanceof Replacement && equalsValue((Replacement)other);
	}

	private boolean equalsValue(Replacement other) {
		return (this.from.equals(other.from) && this.to.equals(other.to));
	}
}
