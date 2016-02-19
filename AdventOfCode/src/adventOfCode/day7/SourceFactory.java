package adventOfCode.day7;

public class SourceFactory{
	public Source create(String inputs){
		String[] i = inputs.split(" ");
		switch (i.length){
		case 1:
			return new Imply(i[0]);
		case 2:
			return new Not(i[1]);
		case 3:
			switch (i[1]){
			case "LSHIFT":
				return new LShift(i[0],i[2]);
			case "RSHIFT":
				return new RShift(i[0],i[2]);
			case "AND":
				return new And(i[0],i[2]);
			case "OR":
				return new Or(i[0],i[2]);
			}
		default:
			return null;
		}
	}
}
