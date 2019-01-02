package billsBurgers;

public class Mustard extends BurgerDecorator{
	
	public Mustard(FoodItem foodItem)
	{
		super(foodItem, 0.10);
	}
}
