package adventOfCode.day15;

public class Spoon {
	public int quantity;
	public Spoon(int quantity){
		this.quantity = quantity;
	}
	public boolean isEmpty(){
		if(quantity==0)
			return true;
		return false;
	}
	public Spoon clone(){
		return new Spoon(quantity);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantity;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spoon other = (Spoon) obj;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
}
