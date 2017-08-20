package adventOfCode.day9;

public class CityDistance{
	public final String cityA;
	public final String cityB;
	public final int distance;
	public CityDistance(String cityA, String cityB, int distance){
		this.cityA = cityA;
		this.cityB = cityB;
		this.distance = distance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityA == null) ? 0 : cityA.hashCode());
		result = prime * result + ((cityB == null) ? 0 : cityB.hashCode());
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
		CityDistance other = (CityDistance) obj;
		if (cityA == null) {
			if (other.cityA != null)
				return false;
		} else if (!cityA.equals(other.cityA) && !cityA.equals(other.cityB))
			return false;
		if (cityB == null) {
			if (other.cityB != null)
				return false;
		} else if (!cityB.equals(other.cityB) && !cityB.equals(other.cityA))
			return false;
		return true;
	}
	
	public boolean equals(String first,String second) {
		if (first == null)
			return false;
		if (second == null)
			return false;
		if (!cityA.equals(first) && !cityA.equals(second))
			return false;
		else if (!cityB.equals(second) && !cityB.equals(first))
			return false;
		return true;
	}
	
}