package adventOfCode.day18;

public class Coordinate {
	public final int line;
	public final int column;
	public Coordinate(String coordinate){
		String[] c = coordinate.split(",");
		line = Integer.valueOf(c[0]);
		column = Integer.valueOf(c[1]);
	}
	public Coordinate(int line, int column){
		this.line = line;
		this.column = column;
	}
	
	public boolean equals(Object other){
		return other instanceof Coordinate && equalsValue((Coordinate)other);
	}
	private boolean equalsValue(Coordinate other) {
		return (this.line == other.line && this.column == other.column);
	}
}
