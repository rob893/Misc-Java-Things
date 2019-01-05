package phone;

public class Contact {

	private int phoneNumber;
	private String name;
	
	public Contact(int phoneNumber, String name)
	{
		this.phoneNumber = phoneNumber;
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printData()
	{
		System.out.println("Name: " + this.name + " Phone Number: " + this.phoneNumber);
	}
}
