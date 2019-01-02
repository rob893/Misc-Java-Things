package billsBurgers;

public class Application {

	public static void main(String[] args) {
		Hamburger burger = new Hamburger();
		
		System.out.println(burger.getTotalCost());
		
		burger.addTopping("cheese");
		burger.addTopping("mustard");
		
		System.out.println(burger.getTotalCost());
	}

}
