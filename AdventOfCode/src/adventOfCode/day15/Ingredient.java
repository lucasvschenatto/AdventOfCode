package adventOfCode.day15;

public class Ingredient {
	private String name;
	private int capacity;
	private int durability;
	private int flavor;
	private int texture;
	private int spoons;
	private int calories;
	public Ingredient(String properties, int spoons) {
		String[] words = properties.split("[,:\\s]");
		name       = words[0];
		capacity   = Integer.valueOf(words[3]);
		durability = Integer.valueOf(words[6]);
		flavor     = Integer.valueOf(words[9]);
		texture    = Integer.valueOf(words[12]);
		calories   = Integer.valueOf(words[15]);
		this.spoons = spoons;
	}
	public int capacityScore()  { return capacity*spoons;   }
	public int durabilityScore(){ return durability*spoons; }
	public int flavorScore()    { return flavor*spoons;     }
	public int textureScore()   { return texture*spoons;    }
	public int caloriesScore()  { return calories*spoons;   }
	public String getName()     { return name;              }
	public void setSpoons(int spoons){this.spoons = spoons; }
	
	@Override
	public String toString(){
		String repr = "{"
				+ " name: "+name
				+ ", capacity: "+capacity
				+ ", durability: "+durability
				+ ", flavor: "+flavor
				+ ", texture: "+texture
				+ ", calories: "+calories
				+ ", spoons: "+spoons
				+ " }";
		return repr;
	}
}
