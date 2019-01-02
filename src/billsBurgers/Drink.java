package billsBurgers;

public class Drink extends BurgerDecorator{
	
	public Drink(FoodItem foodItem)
	{
		super(foodItem, 1.25);
	}
}
