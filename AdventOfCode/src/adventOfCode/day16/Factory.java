package adventOfCode.day16;

class Factory {
	public static Strategy create(String hint){
		String hintName = hint.substring(0, hint.indexOf(": "));
		String hintValue = hint.substring(hint.indexOf(": ")+2,hint.length());
		switch (hintName) {
		//			case "cats":
		//				return new Cats();
		//			case "trees":
		//				return new Trees();
		//			case "pomeranians":
		//				return new Pomeranians();
		//			case "goldfish":
		//				return new GoldFish();
		default:
			return new Default(hintName, hintValue);
		}
	}
}
class Default implements Strategy{
	protected String name;
	protected String value;
	Default(String name, String value){
		this.name = name;
		this.value = value;
	}
	public boolean match(String other) {
		return (nameMatches(other) && valueMatches(other))? true:false;
	}
	protected boolean nameMatches(String other){
		String otherName = other.substring(0, other.indexOf(": "));
		return name.equals(otherName)? true:false;
	}
	protected boolean valueMatches(String other){
		String otherValue = other.substring(other.indexOf(": ")+2,other.length());
		return value.equals(otherValue)? true:false;
	}
}
class GreaterThan extends Default implements Strategy{	
	GreaterThan(String name,String value){
		super(name, value);
	}
	@Override
	protected boolean valueMatches(String atribute) {
		return false;
	}		
}
class FewerThan extends Default implements Strategy{	
	FewerThan(String name,String value){
		super(name, value);
	}
	@Override
	protected boolean valueMatches(String atribute) {
		return false;
	}		
}
class Cats extends GreaterThan implements Strategy{	
	Cats(String value){
		super("cats", value);
	}
}
class Trees extends GreaterThan implements Strategy{
	Trees(String value){
		super("trees", value);
	}
}
class Pomeranians extends Default implements Strategy{
	Pomeranians(String value){
		super("pomeranians", value);
	}
}
class GoldFish extends Default implements Strategy{
	GoldFish(String value){
		super("GoldFish", value);
	}	
}