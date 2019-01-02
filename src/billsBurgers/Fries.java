package billsBurgers;

public class Fries extends BurgerDecorator{
	
	public Fries(FoodItem foodItem)
	{
		super(foodItem, 1);
	}
}
