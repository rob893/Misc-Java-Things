package billsBurgers;

public abstract class BurgerDecorator extends FoodItem {
	
	private double baseCost;
	private FoodItem foodItem;
	
	
	protected BurgerDecorator(FoodItem foodItem, double baseCost) 
	{
		this.baseCost = baseCost;
		this.foodItem = foodItem;
	}
	
	public void printInfo()
	{
		System.out.println("Added " + this.getClass().getSimpleName() + " for an extra " + this.getBaseCost());
	}
	
	public double getBaseCost()
	{
		return baseCost;
	}
	
	public double getCost()
	{
		return foodItem.getCost() + this.baseCost;
	}
}
