package adventOfCode;

import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.nimbus.State;

import adventOfCode.day8.*;

public class Day8 implements Challenge{
	Mode code;
	Mode inMemory;
	public void spaceOf(String list) {
		code = new Code(list);
		inMemory = new InMemory(list);
		code.run();
		inMemory.run();
	}

	public int getCodeSpace() {
		return code.getSpace();
	}

	public int getInMemorySpace() {
		return inMemory.getSpace();
	}
	public int getSpaceDifference(){
		return getCodeSpace() - getInMemorySpace();
	}
	@Override
	public String part1(String input) {
		Day8 d = new Day8();
		d.spaceOf(input);
		return String.valueOf(d.getSpaceDifference());
	}

	@Override
	public String part2(String input) {
		Day8 d = new Day8();
		d.spaceOf(input);
		return String.valueOf(d.getSpaceDifference());
	}
	private abstract class Mode{
		protected int space;
		protected String list;
		public abstract void run();
		private int getSpace(){
			return space;
		}
		protected List<String>getLines(String list){
			return Arrays.asList(list.split("\n"));
		}
	}
	private class Code extends Mode{
		Code(String list){
			this.list = list;
		}
		@Override
		public void run() {
			this.space = list.length();
			
		}
	}
	private class InMemory extends Mode{
		InMemory(String list){
			this.list = list;
		}

		@Override
		public void run() {
			StateContext context = new StateContext();
			for (char c : list.toCharArray()) {
				context.readChar(c);
			}
			space = context.getCount();
		}
	}
}