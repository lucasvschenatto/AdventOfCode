package adventOfCode;

import adventOfCode.day8.*;
import adventOfCode.submit.Challenge;

public class Day8 implements Challenge{
	Mode code;
	Mode inMemory;
	Mode enCoded;
	public void spaceOf(String list) {
		code = new Code(list);
		inMemory = new InMemory(list);
		enCoded = new Encoded(list);
		code.run();
		inMemory.run();
		enCoded.run();
	}

	public int getCodeSpace() {
		return code.getSpace();
	}

	public int getInMemorySpace() {
		return inMemory.getSpace();
	}
	public int getEncodedSpace() {
		return enCoded.getSpace();
	}
	public int getInMemoryDifference(){
		return getCodeSpace() - getInMemorySpace();
	}
	public int getEncodedDifference() {
		return getEncodedSpace() - getCodeSpace();
	}
	@Override
	public String part1(String input) {
		Day8 d = new Day8();
		d.spaceOf(input);
		return String.valueOf(d.getInMemoryDifference());
	}

	@Override
	public String part2(String input) {
		Day8 d = new Day8();
		d.spaceOf(input);
		return String.valueOf(d.getEncodedDifference());
	}
	private static class Mode{
		protected StateContext context;
		protected int space;
		protected String list;
		protected Action action;
		final void run(){
			context = new StateContext();
			for (char c : list.toCharArray()) {
				context.readChar(c);
			}
			action.execute();
		}
		int getSpace(){
			return space;
		}
		private interface Action{
			public void execute();
		}
	}
	private class Code extends Mode{
		Code(String list){
			this.list = list;
			action = () -> space = list.replace("\n", "").length();
		}
	}
	private class InMemory extends Mode{
		InMemory(String list){
			this.list = list;
			action = () -> space = context.getInMemoryCount();
		}
	}
	private class Encoded extends Mode{
		Encoded(String list){
			this.list = list;
			action = () ->{
				context.readChar('\u0000');
				space = context.getEncodedCount();
			};
		}
	}
}
