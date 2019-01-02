package billsBurgers;

public class DeluxeBurger extends Hamburger{

	public DeluxeBurger()
	{
		this("White", "Beef", 5);
	}
	
	public DeluxeBurger(String breadRollType, String meat, int basePrice) {
		super(breadRollType, meat, basePrice, 0);
		setCompleteBurger(new Fries(getCompleteBurger()));
		setCompleteBurger(new Drink(getCompleteBurger()));
	}

}
