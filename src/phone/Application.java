package phone;

import java.util.Scanner;

public class Application {
	
	private static void addContact(MobilePhone phone, Scanner scanner)
	{
		System.out.println("Enter contact name.");
		String name = scanner.nextLine();
		System.out.println("Enter contact number.");
		int number = scanner.nextInt();
		
		phone.addContact(number, name);
	}
	
	private static void removeContact(MobilePhone phone, Scanner scanner)
	{
		System.out.println("Enter name of contact to remove:");
		String name = scanner.nextLine();
		phone.removeContact(name);
	}
	
	private static void updateContact(MobilePhone phone, Scanner scanner)
	{
		System.out.println("Enter name of contact to update");
		String name = scanner.nextLine();
		if(phone.hasContact(name))
		{
			System.out.println("Enter new name:");
			String newName = scanner.nextLine();
			System.out.println("Enter new number:");
			int newNumber = scanner.nextInt();
			phone.updateContact(name, newName, newNumber);
		}
		else
		{
			System.out.println("This contact does not exist!");
		}
	}
	
	private static void queryContacts(MobilePhone phone, Scanner scanner)
	{
		System.out.println("Enter contact name to query:");
		String name = scanner.nextLine();
		
		if(phone.hasContact(name))
		{
			phone.getContact(name).printData();
		}
		else
		{
			System.out.println("This contact does not exit.");
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MobilePhone phone = new MobilePhone(555);
		
		boolean running = true;
		
		while(running)
		{
			System.out.println("Enter action:");
			
			if(!scanner.hasNextInt())
			{
				System.out.println("Goodbye");
				running = false;
				break;
			}
			
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch (action) 
			{
			case 1:
				phone.printContacts();
				break;
			case 2:
				addContact(phone, scanner);
				break;
			case 3:
				removeContact(phone, scanner);
				break;
			case 4:
				updateContact(phone, scanner);
				break;
			case 5:
				queryContacts(phone, scanner);
				break;
			default:
				System.out.println("Goodbye");
				running = false;
				break;
			}
		}
		
		scanner.close();
	}
}
