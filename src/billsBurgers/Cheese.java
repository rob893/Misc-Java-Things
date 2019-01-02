package billsBurgers;

public class Cheese extends BurgerDecorator{
	
	public Cheese(FoodItem foodItem)
	{
		super(foodItem, 0.50);
	}
}
