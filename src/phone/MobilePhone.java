package phone;

import java.util.ArrayList;

public class MobilePhone {
	
	private int myNumber;
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	
	public MobilePhone(int myNumber)
	{
		this.myNumber = myNumber;
	}
	
	public void addContact(int phoneNumber, String name)
	{
		if(!hasContact(name))
		{
			Contact newContact = new Contact(phoneNumber, name);
			contacts.add(newContact);
			System.out.println("Contact added!");
		}
		else
		{
			System.out.println("This contact already exitis!");
		}
	}
	
	public void removeContact(String name)
	{
		int index = getIndex(name);
		
		if(index >= 0)
		{
			contacts.remove(index);
			System.out.println("Contact removed!");
		}
		else
		{
			System.out.println("This contact does not exist!");
		}
	}
	
	public void updateContact(String name, String newName, int phoneNumber)
	{
		int index = getIndex(name);
		
		if(index >= 0)
		{
			contacts.get(index).setName(newName);
			contacts.get(index).setPhoneNumber(phoneNumber);
			System.out.println("Contact updated!");
		}
		else
		{
			System.out.println("This contact does not exist!");
		}
	}
	
	public void printContacts()
	{
		System.out.println("Your contacts:");
		for(Contact contact : contacts)
		{
			contact.printData();
		}
	}
	
	public boolean hasContact(String name)
	{
		for(Contact contact : contacts)
		{
			if(contact.getName().equals(name))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public Contact getContact(String name)
	{
		int index = getIndex(name);
		
		if(index >= 0)
		{
			return contacts.get(index);
		}
		
		return null;
	}
	
	private int getIndex(String name)
	{
		for(Contact contact : contacts)
		{
			if(contact.getName().equals(name))
			{
				return contacts.indexOf(contact);
			}
		}
		
		return -1;
	}
}
