package adventOfCode.day16;

public abstract class Factory {
	private static Factory strategyMachine;
	protected abstract Strategy createFor(String hintName, String hintValue);
	public static void setOldMachine(){
		strategyMachine = new Factory(){
			protected Strategy createFor(String hintName,String hintValue){
				return new Default(hintName, hintValue);
			}
		};
	}
	public static void setNewMachine(){
		strategyMachine = new Factory(){
			protected Strategy createFor(String hintName,String hintValue){
				switch (hintName) {
							case "cats":
								return new Cats(hintValue);
							case "trees":
								return new Trees(hintValue);
							case "pomeranians":
								return new Pomeranians(hintValue);
							case "goldfish":
								return new GoldFish(hintValue);
				default:
					return new Default(hintName, hintValue);
				}
			}
		};
	}
	public static Strategy create(String hint){
		String hintName = hint.substring(0, hint.indexOf(": "));
		String hintValue = hint.substring(hint.indexOf(": ")+2,hint.length());
		return strategyMachine.createFor(hintName,hintValue);
	}
}
class Default implements Strategy{
	protected String name;
	protected int value;
	Default(String name, String value){
		this.name = name;
		this.value = Integer.valueOf(value);
	}
	public boolean match(String other) {
		String otherName = other.split(": ")[0];
		int otherValue = Integer.valueOf(other.split(": ")[1]); 
		return (nameMatches(otherName) && valueMatches(otherValue))? true:false;
	}
	protected boolean nameMatches(String otherName){
		return name.equals(otherName)? true:false;
	}
	protected boolean valueMatches(int otherValue){
		return value == otherValue? true:false;
	}
}
class GreaterThan extends Default implements Strategy{	
	GreaterThan(String name,String value){
		super(name, value);
	}
	@Override
	protected boolean valueMatches(int otherValue) {
		return otherValue>value?true:false;
	}		
}
class FewerThan extends Default implements Strategy{	
	FewerThan(String name,String value){
		super(name, value);
	}
	@Override
	protected boolean valueMatches(int otherValue) {
		return otherValue<value?true:false;
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
class Pomeranians extends FewerThan implements Strategy{
	Pomeranians(String value){
		super("pomeranians", value);
	}
}
class GoldFish extends FewerThan implements Strategy{
	GoldFish(String value){
		super("goldfish", value);
	}	
}