package udemyCourse;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
	
	public static void main(String[] args) 
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++)
		{
			list.add(i);
		}
		
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}
}
