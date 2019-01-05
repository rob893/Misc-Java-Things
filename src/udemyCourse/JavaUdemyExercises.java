package udemyCourse;

import java.util.Scanner;

public class JavaUdemyExercises {

	public static double convertToKg(double pounds)
	{
		return pounds * 0.45359237d;
	}
	
	public static String getDurationString(int minutes, int seconds)
	{
		if(minutes < 0 || (seconds < 0 || seconds > 59))
		{
			return "Invalid value";
		}
		
		int hours = minutes / 60;
		int mins = minutes % 60;
		
		return hours + "h " + mins + "m " + seconds + "s";
	}
	
	public static String getDurationString(int seconds)
	{
		if(seconds < 0)
		{
			return "Invalid input.";
		}
		
		int mins = seconds / 60;
		int secs = seconds % 60;
		
		return getDurationString(mins, secs);
	}
	
	public static void sum3And5()
	{
		int sum = 0;
		int count = 0;
		
		for(int i = 1; i <= 1000; i++)
		{
			if(i % 3 == 0 && i % 5 == 0)
			{
				sum += i;
				System.out.println(i);
				count++;
				
				if(count == 5)
				{
					break;
				}
			}
		}
		
		System.out.println(sum);
	}
	
	public static int sumDigits(int num)
	{
		if(num < 10)
		{
			return -1;
		}
		
		int sum = 0;
		
		while(num > 0)
		{
			sum += num % 10;
			num /= 10;
		}
		
		return sum;
	}
	
	public static boolean isNumPal(int num)
	{
		num = Math.abs(num);
		return Integer.parseInt(new StringBuilder("" + num).reverse().toString()) == num;
	}
	
	public static void printSquareStar(int num)
	{
	    if(num < 5)
	    {
	        System.out.println("Invalid Value");
	        return;
	    }
	
		for(int i = 1; i <= num; i++)
		{
		    for(int j = 1; j <= num; j++)
		    {
		        if(i == 1 || i == num)
		        {
		            System.out.print("*");
		        }
		        else if(j == 1 || j == num)
		        {
		            System.out.print("*");
		        }
		        else if(i == j)
		        {
		            System.out.print("*");
		        }
		        else if(j == num - i + 1)
		        {
		            System.out.print("*");
		        }
		        else
		        {
		            System.out.print(" ");
		        }
		    }
		        
		    System.out.println();
		}
	}
	
	public static void enterName()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter year of birth:");
		boolean hasNextInt = scanner.hasNextInt();
		
		if(hasNextInt)
		{
			int yearOfBirth = scanner.nextInt();
			
			scanner.nextLine(); //handle next line character
			
			System.out.println("Enter your name:");
			String name = scanner.nextLine();
			
			int age = 2019 - yearOfBirth;
			
			if(age >= 0 && age <= 100)
			{
				System.out.println("Your name is " + name + " and you are " + age + " years old!");
			}
			else
			{
				System.out.println("Invalid year of birth.");
			}
		}
		else
		{
			System.out.println("Unable to parse birth year");
		}
		
		scanner.close();
	}
	
	public static void printSumEnteredNums()
	{
		Scanner scanner = new Scanner(System.in);
		
		int count = 1;
		int sum = 0;
		while(count <= 10)
		{
			System.out.println("Enter number #" + count);
			
			if(scanner.hasNextInt())
			{
				sum += scanner.nextInt();
				count++;
			}
			else
			{
				System.out.println("Invalid number");
			}
			
			scanner.nextLine(); //handle end of line.
		}
		
		System.out.println(sum);
		scanner.close();
	}
	
	public static void enterMinMax()
	{
		Scanner scanner = new Scanner(System.in);
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		while(true)
		{
			if(scanner.hasNextInt())
			{
				int enteredNum = scanner.nextInt();
				min = Math.min(min, enteredNum);
				max = Math.max(max, enteredNum);
			}
			else
			{
				break;
			}
			
			scanner.nextLine(); //handle new line
		}
		
		System.out.println("Min: " + min + " Max: " + max);
		scanner.close();
	}
	
	public static int[] getIntegers(int num)
	{
		Scanner scanner = new Scanner(System.in);
		int[] result = new int[num];
		System.out.println("Enter " + num + " numbers.");
		
		
		for(int i = 0; i < result.length; i++)
		{
			result[i] = scanner.nextInt();
		}
		
		scanner.close();
		return result;
	}
	
	public static void printArray(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static int[] sortDesc(int[] arr)
	{
		int[] result = arr.clone();
		
		for(int i = 0; i< result.length - 1; i++)
		{
			for(int j = i + 1; j < result.length; j++)
			{
				if(result[i] < result[j])
				{
					int temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
			}
		}
		
		return result;
	}
	
	public static int findMin(int[] arr)
	{
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++)
		{
			min = Math.min(min, arr[i]);
		}
		
		return min;
	}
	
	public static void reverseArray(int[] arr)
	{
		for(int i = 0, j = arr.length - 1; i < j; i++, j--)
		{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
