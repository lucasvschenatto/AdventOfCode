package adventOfCode;

public class ChallengeFactory {
	public Challenge create(String dayNumber){
		switch (dayNumber){
		case "1":
			return new Day1();
		case "2":
			return new Day2();
		case "3":
			return new Day3();
		case "4":
			return new Day4();		
		case "5":
			return new Day5();
		case "6":
		case "7":
		case "8":
		case "9":
		case "10":
		case "11":
		case "12":
		case "13":
		case "14":
		case "15":
		case "16":
		case "17":
		case "18":
		case "19":
		case "20":
		case "21":
		case "22":
		case "23":
		case "24":
		case "25":
		default:
			return new NotImplemented();
		}
	}
}
