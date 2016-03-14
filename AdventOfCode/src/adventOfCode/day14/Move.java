package adventOfCode.day14;

public class Move extends ReindeerState {
	protected Move(int capacity) {
		super(capacity);
	}

	@Override
	public void fly(int time, Reindeer r) {
		if (time>=timeLeft){
			r.increaseDistance(timeLeft*r.getSpeed());
			r.setState(new Rest(r.getRest()));
			r.state.fly(time - timeLeft,r);
		}else{
			timeLeft = timeLeft - time;
			r.increaseDistance(time*r.getSpeed());
		}
	}

}
