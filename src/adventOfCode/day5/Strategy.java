package adventOfCode.day5;

public enum Strategy {
	THREEVOWELS ( (subject) ->{
		int vowels = 0;
		for (int i = 0; i<subject.length();i++)
			if("aeiou".indexOf(subject.charAt(i)) >= 0)
				vowels++;
		return (vowels>=3)? true:false;
	}),
	LETTERTWICE ( (subject) ->{
		for(int i = 0; i < (subject.length()-1); i++)
			if(subject.charAt(i) == subject.charAt(i+1))
				return true;
		return false;
	}),
	REJECTEDSUBSTRING ( (subject) ->{
		if(subject.contains("ab") || subject.contains("cd")
		|| subject.contains("pq") || subject.contains("xy"))
			return false;
		return true;
	}),
	PAIRNOTOVERLAPING( (subject) ->{
		for(int i = 0; i < (subject.length()-1); i++){
			for(int j = i+2; j < subject.length()-1; j++)
				if(subject.substring(i,i+2).equals(subject.substring(j,j+2)))
					return true;
		}
		return false;
	}),
	REPEATWITHONEBETWEEN( (subject) ->{
		for(int i = 0; i < (subject.length()-2); i++)
			if(subject.charAt(i) == subject.charAt(i+2))
				return true;
		return false;
	});
	
	private Command action;
	private Strategy(Command c){
		action = c;
	}
	public boolean check(String subject){
		return action.check(subject);
	}
	
}