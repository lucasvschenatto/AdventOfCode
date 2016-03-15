package adventOfCode.day15;

public class Ingredient {
	private String name;
	private int capacity;
	private int durability;
	private int flavor;
	private int texture;
	private int spoons;
	public Ingredient(String properties, int spoons) {
		String[] words = properties.split("[,\\s]");
		name       = words[0];
		capacity   = Integer.valueOf(words[2]);
		durability = Integer.valueOf(words[5]);
		flavor     = Integer.valueOf(words[8]);
		texture    = Integer.valueOf(words[11]);
		this.spoons = spoons;
	}
	public int capacityScore()  { return capacity*spoons;   }
	public int durabilityScore(){ return durability*spoons; }
	public int flavorScore()    { return flavor*spoons;     }
	public int textureScore()   { return texture*spoons;    }
	public String getName()     { return name;              }
}
