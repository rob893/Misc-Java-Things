package billsBurgers;

public class Lettuce extends BurgerDecorator{
	
	public Lettuce(FoodItem foodItem)
	{
		super(foodItem, 0.50);
	}
}
