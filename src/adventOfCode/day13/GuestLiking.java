package adventOfCode.day13;

public class GuestLiking{
	public final String guestA;
	public final String guestB;
	public final int happinessPoints;
	public GuestLiking(String guestA, String guestB, int happinessPoints){
		this.guestA = guestA;
		this.guestB = guestB;
		this.happinessPoints = happinessPoints;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guestA == null) ? 0 : guestA.hashCode());
		result = prime * result + ((guestB == null) ? 0 : guestB.hashCode());
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
		GuestLiking other = (GuestLiking) obj;
		if (guestA == null) {
			if (other.guestA != null)
				return false;
		} else if (!guestA.equals(other.guestA) && !guestA.equals(other.guestB))
			return false;
		if (guestB == null) {
			if (other.guestB != null)
				return false;
		} else if (!guestB.equals(other.guestB) && !guestB.equals(other.guestA))
			return false;
		return true;
	}
	
	public boolean equals(String first,String second) {
		if (first == null)
			return false;
		if (second == null)
			return false;
		if (!guestA.equals(first) && !guestA.equals(second))
			return false;
		else if (!guestB.equals(second) && !guestB.equals(first))
			return false;
		return true;
	}
	
}