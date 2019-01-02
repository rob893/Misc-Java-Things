package udemyCourse;

public class Chair {
	
	private int numLegs;
	private String material;
	
	
	public Chair()
	{
		this(4, "Oak");
	}
	
	public Chair(int numLegs, String material) 
	{
		this.numLegs = numLegs;
		this.material = material;
	}
	
	public int getNumLegs() 
	{
		return numLegs;
	}
	
	public void setNumLegs(int numLegs) 
	{
		this.numLegs = numLegs;
	}
	
	public String getMaterial() 
	{
		return material;
	}
	
	public void setMaterial(String material) 
	{
		this.material = material;
	}
	
	public void sit()
	{
		System.out.println("You are sitting in the chair");
	}
}
