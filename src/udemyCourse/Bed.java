package udemyCourse;

public class Bed {
	
	private String size;
	private int thickness;
	
	
	public Bed()
	{
		this("Twin", 5);
	}
	
	public Bed(String size, int thickness) 
	{
		this.size = size;
		this.thickness = thickness;
	}
	
	public String getSize() 
	{
		return size;
	}
	public void setSize(String size) 
	{
		this.size = size;
	}
	public int getThickness() 
	{
		return thickness;
	}
	public void setThickness(int thickness) 
	{
		this.thickness = thickness;
	}
	
	public void sleep()
	{
		System.out.println("You are sleeping");
	}
	
	public void makeBed()
	{
		System.out.println("You are making the bed");
	}
}
