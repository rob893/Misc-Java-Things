package testPackage;

import java.util.Arrays;

public class MiscFunctions 
{
	public static String recursionRevString(String str)
	{
		if(str == null)
		{
			return "";
		}
		if(str.length() <= 1)
		{
			return str;
		}
		
		return recursionRevString(str.substring(1, str.length())) + str.charAt(0);
	}
	
	public static String revString(String str)
	{
		StringBuilder builder = new StringBuilder(str);
		builder.reverse();
		
		return builder.toString();
	}
	
	public static boolean isPowerOf(int num, int base)
	{
		if(base == 2)
		{
			return (num & num - 1) == 0;
		}
		
		if(base == 10)
		{
			return Math.log10(num) == (int)Math.log10(num);
		}
		
		return (Math.log10(num) / Math.log10(base)) == (int)(Math.log10(num) / Math.log10(base));
	}
	
	public static boolean hasUniqueChars(String str)
	{
		for(int i = 0; i < str.length() - 1; i++)
		{
			for(int j = i + 1; j < str.length(); j++)
			{
				if(str.charAt(i) == str.charAt(j))
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static String stringCompression(String str)
	{
		String result = "";
		int count = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			count++;
			
			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1))
			{
				result += str.charAt(i) + "" + count;
				count = 0;
			}
		}
		
		return result.length() < str.length() ? result : str;
	}
	
	public static String URLify(String str, int trueLen)
	{
		if(str == null)
		{
			return null;
		}
		
		return str.replaceAll(" ", "%20");
	}
	
	public static int fib(int n)
	{
		if(n <= 0)
		{
			return 0;
		}
		if(n == 1)
		{
			return 1;
		}
		
		return fib(n - 1) + fib(n - 2);
	}
	
	public static int betterFib(int n) //bottom up DP approach
	{
		if(n <= 0)
		{
			return 0;
		}
		
		if(n < 2)
		{
			return 1;
		}
		
		int prevFib = 1;
		int currentFib = 1;
		
		for(int i = 2; i < n; i++)
		{
			int newFib = prevFib + currentFib;
			prevFib = currentFib;
			currentFib = newFib;
		}
		
		return currentFib;
	}
	
	public static int secondSmallest(int[] arr)
	{
		Arrays.sort(arr);
		return arr[1];
	}
}
