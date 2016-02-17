package adventOfCode;

import java.util.Arrays;
import java.util.List;

public class Day8 {
	Mode code;
	Mode inMemory;
	public void spaceOf(String list) {
		code = new Code(list);
		inMemory = new InMemory(list);
	}

	public int getCodeSpace() {
		return code.getSpace();
	}

	public int getInMemorySpace() {
		return inMemory.getSpace();
	}
	private abstract class Mode{
		protected int space;
		private int getSpace(){
			return space;
		}
		protected List<String>getLines(String list){
			return Arrays.asList(list.split("\n"));
		}
	}
	private class Code extends Mode{
		Code(String list){
			space = list.length();
		}
	}
	private class InMemory extends Mode{
		InMemory(String list){
			String local = list.replace("\"","");
			space = local.length();
		}
	}
}
