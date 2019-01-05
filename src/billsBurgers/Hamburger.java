package billsBurgers;


public class Hamburger extends FoodItem{
	
	private String breadRollType;
	private String meat;
	private double basePrice;
	private int numToppings = 0;
	private int maxToppings = 4;
	private FoodItem completeBurger;
	
	
	public Hamburger()
	{
		this("White Roll", "Beef", 5);
	}
	
	public Hamburger(String breadRollType, String meat, double basePrice)
	{
		this(breadRollType, meat, basePrice, 4);
	}
	
	protected Hamburger(String breadRollType, String meat, double basePrice, int maxToppings)
	{
		this.basePrice = basePrice;
		this.breadRollType = breadRollType;
		this.meat = meat;
		this.completeBurger = this;
		this.numToppings = 0;
		this.maxToppings = maxToppings;
	}
	
	public double getCost()
	{
		return this.basePrice;
	}
	
	public double getTotalCost()
	{
		return this.completeBurger.getCost();
	}
	
	public String getBreadRollType()
	{
		return this.breadRollType;
	}
	
	public FoodItem getCompleteBurger()
	{
		return this.completeBurger;
	}
	
	public String getMeat()
	{
		return this.meat;
	}
	
	protected void setCompleteBurger(FoodItem completeBurger)
	{
		this.completeBurger = completeBurger;
	}
	
	public void addTopping(String topping)
	{
		if(this.numToppings >= this.maxToppings)
		{
			System.out.println("Cannot add more toppings to this burger!");
			return;
		}
		
		topping = topping.toLowerCase();
		BurgerDecorator newBurger;
		
		switch(topping)
		{
			case "lettuce":
				newBurger = new Lettuce(this.completeBurger);
				newBurger.printInfo();
				this.completeBurger = newBurger;
				break;
			case "mustard":
				newBurger = new Mustard(this.completeBurger);
				newBurger.printInfo();
				this.completeBurger = newBurger;
				break;
			case "pickles":
				newBurger = new Pickles(this.completeBurger);
				newBurger.printInfo();
				this.completeBurger = newBurger;
				break;
			case "cheese":
				newBurger = new Cheese(this.completeBurger);
				newBurger.printInfo();
				this.completeBurger = newBurger;
				break;
			default:
				System.out.println("Invalid topping!");
				return;
		}
		
		numToppings++;
	}
}
