package billsBurgers;

public class Pickles extends BurgerDecorator{
	
	public Pickles(FoodItem foodItem)
	{
		super(foodItem, 0.25);
	}
}
