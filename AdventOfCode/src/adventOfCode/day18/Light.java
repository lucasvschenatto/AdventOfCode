package adventOfCode.day18;

public enum Light{
	ON((surroundingOn)->{
		return (surroundingOn == 2 || surroundingOn == 3)? true: false;
	})
	,OFF((surroundingOn)->{
		return (surroundingOn == 3)? true: false;
	});
	
	public static Light valueOf(char light){
		return light=='#'? ON:OFF;
	}
	public boolean onStepIsOn(int surrounding){
		return onStep.isOn(surrounding);
	}
	private OnStep onStep;
	private Light(OnStep onStep){
		this.onStep = onStep;
	}
	private interface OnStep{
		boolean isOn(int surrounding);
	}
}
