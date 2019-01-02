package udemyCourse;

public class Printer {
	
	private int tonerLevel = 100;
	private int numPagesPrinted = 0;
	private boolean isDuplex = false;
	
	public Printer()
	{
		this(100, false);
	}
	
	public Printer(int tonerLevel, boolean isDuplex)
	{
		if(tonerLevel >= 0 && tonerLevel <= 100)
		{
			this.tonerLevel = tonerLevel;
		}
		else
		{
			this.tonerLevel = 100;
		}
		
		this.isDuplex = isDuplex;
	}
	
	public int getTonerLevel()
	{
		return this.tonerLevel;
	}
	
	public int getNumPagesPrinted()
	{
		return this.numPagesPrinted;
	}
	
	public boolean getIsDuplex()
	{
		return this.isDuplex;
	}
	
	public void addToner(int amount)
	{
		this.tonerLevel = Math.max(0, Math.min(100, this.tonerLevel + amount));
	}
	
	public void printPage()
	{
		this.numPagesPrinted++;
		
		if(this.isDuplex)
		{
			System.out.println("this will print on second page too");
		}
	}
}
