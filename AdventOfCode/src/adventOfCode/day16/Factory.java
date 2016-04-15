package adventOfCode.day16;

class Factory {
	protected static DinamicKey KEY;
	public Factory(DinamicKey key) {
		this.KEY = key;
	}

	public Strategy create(String hint){
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
class Cats extends Default implements Strategy{	
	Cats(String value) {super("cats", value);}

	public void match(String atribute) {
	}		
}
class Trees extends Default implements Strategy{
	Trees(String value){super("trees", value);}
	public void match(String atribute) {
	}		
}
class Pomeranians extends Default implements Strategy{
	Pomeranians(String value){super("pomeranians", value);}
	public void match(String atribute) {
	}		
}
class GoldFish extends Default implements Strategy{
	GoldFish(String value){super("GoldFish", value);}
	public void match(String atribute) {
	}		
}
class Default implements Strategy{
	protected String name;
	protected String value;
	Default(String name, String value){
		this.name = name;
		this.value = value;
	}
	public void match(String attribute) {
		boolean result = true;
		if (name.equals(attribute.substring(0, attribute.indexOf(": "))))
			result = false;
		if(value.equals(attribute.substring(attribute.indexOf(": ")+2,attribute.length())))
			result = false;
		Factory.KEY.setLastMatch(result);
	}		
}