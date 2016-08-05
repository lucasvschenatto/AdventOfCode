package adventOfCode.day17;

public class ExclusiveInt extends Number{
	private static final long serialVersionUID = -8881631629116834438L;
	private int value;
	ExclusiveInt(int value){
		this.value = value;
	}
	public static ExclusiveInt valueOf(String s) {
		return new ExclusiveInt(Integer.valueOf(s).intValue());
	}
	public boolean equals(Object other){
		return this == other;
	}
	public int hashCode(){
		return value;
	}
	public int intValue() {
		return value;
	}
	public long longValue() {
		return value;
	}
	public float floatValue() {
		return value;
	}
	public double doubleValue() {
		return value;
	}
}
