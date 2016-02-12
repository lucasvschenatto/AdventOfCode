package adventOfCode;

public class Day5 {

	public int countNices(String strings) {
		Requirement threeVowels = (s) ->{
			int vowels = 0;
			for (int i = 0; i<s.length();i++)
				switch (s.charAt(i)){
				case 'a':
					vowels++;
					break;
				case 'e':
					vowels++;
					break;
				case 'i':
					vowels++;
					break;
				case 'o':
					vowels++;
					break;
				case 'u':
					vowels++;
					break;
				};
			return (vowels>=3)? true:false;
		};
		return 0;
	}
	private interface Requirement{
		boolean check(String subject);
	}
}
