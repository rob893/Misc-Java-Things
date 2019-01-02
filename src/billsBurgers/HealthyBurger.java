package billsBurgers;

public class HealthyBurger extends Hamburger{
	
	public HealthyBurger() {
		this("Beef", 6);
	}
	
	public HealthyBurger(String meat, int basePrice) {
		super("Brown Rye Bread Roll", meat, basePrice, 6);
	}

}
