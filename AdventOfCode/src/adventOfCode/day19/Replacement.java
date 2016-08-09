package adventOfCode.day19;

public class Replacement {
	public final static String SEPARATOR = " => ";
	public final String from;
	public final String to;

	public Replacement(String replacement){
		String [] arguments = replacement.split(SEPARATOR);
		this.from = arguments[0];
		this.to = arguments[1];
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
