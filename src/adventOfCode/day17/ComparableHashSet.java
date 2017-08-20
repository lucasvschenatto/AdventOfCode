package adventOfCode.day17;

import java.util.HashSet;

@SuppressWarnings("serial")
public class ComparableHashSet<E> extends HashSet<E> {
	@SuppressWarnings("unchecked")
	public boolean equals(Object other){
		return other instanceof ComparableHashSet && equalsValue((ComparableHashSet<E>)other);
	}
	private boolean equalsValue(ComparableHashSet<E> other) {
		B result = new B(true);
		if(this.size() != other.size())
			result.value = false;
		else
			forEach((c)->{if(!other.contains(c))result.value = false;});
		return result.value;
	}
	public int hashCode(){
		I sum = new I(0);
		forEach((c) -> sum.value+=c.hashCode());
		return sum.value;
	}
	private class B{
		private boolean value;
		private B(boolean value){this.value = value;}
	}
	private class I{
		private int value;
		private I(int value){this.value = value;}
	}
}
