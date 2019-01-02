package udemyCourse;

public class Dog extends Animal {
	
	private int eyes;
	private int legs;
	private int tail;
	private int teeth;
	private String coat;
	
	
	public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
		super(name, 1, 1, size, weight);
		
		this.eyes = eyes;
		this.legs = legs;
		this.tail = tail;
		this.teeth = teeth;
		this.coat = coat;
	}
	
	@Override
	public void eat()
	{
		System.out.println("dog eating!");
		chew();
		super.eat();
	}
	
	private void chew()
	{
		System.out.println("chewing!");
	}
	
	public void walk()
	{
		System.out.println("walking");
		move(5);
	}
	
	public void run()
	{
		System.out.println("running");
		move(10);
	}

	@Override
	public void move(int speed) {
		
		super.move(speed);
	}
}
