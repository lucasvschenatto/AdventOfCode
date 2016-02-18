package adventOfCode.submit;

import java.lang.reflect.InvocationTargetException;

import adventOfCode.*;
import adventOfCode.day8.NotImplemented;

public class ChallengeFactory {
	public Challenge create(String dayNumber){
			try {
				return (Challenge) Class.forName("adventOfCode.Day"+dayNumber).getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				return new NotImplemented();
			}
	}
}