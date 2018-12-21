package testPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GarbageSort 
{
	public static void sort(int[] arr)
	{
		int[] sortedArr = getNewArray(arr.length);
		
		while(!isSorted(sortedArr) || !checkIfContainsSame(arr, sortedArr))
		{
			sortedArr = getNewArray(arr.length);
		}
		
		System.arraycopy(sortedArr, 0, arr, 0, arr.length);
	}
	
	private static boolean isSorted(int[] arr)
	{
		for(int i = 0; i < arr.length - 1; i++)
		{
			if(arr[i] > arr[i + 1])
			{
				return false;
			}
		}

		return true;
	}
	
	private static int[] getNewArray(int size)
	{
		int[] newArray = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			Random random = new Random();
			newArray[i] = random.nextInt(); //Random int value between MIN_VALUE and MAX_VALUE
		}
		
		return newArray;
	}
	
	private static boolean checkIfContainsSame(int[] arr1, int[] arr2)
	{
		if(arr1.length != arr2.length)
		{
			return false;
		}
		
		HashMap<Integer, Integer> map1 = new HashMap<Integer,Integer>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer,Integer>();
		
		for(int i = 0; i < arr1.length; i++)
		{
			if(map1.containsKey(arr1[i]))
			{
				map1.put(arr1[i], map1.get(arr1[i]) + 1);
			}
			else
			{
				map1.put(arr1[i], 1);
			}
			
			if(map2.containsKey(arr2[i]))
			{
				map2.put(arr2[i], map2.get(arr2[i]) + 1);
			}
			else
			{
				map2.put(arr2[i], 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : map1.entrySet())
		{
			if(!map2.containsKey(entry.getKey()) || entry.getValue() != map2.get(entry.getKey()))
			{
				return false;
			}
		}
			
		return true;
	}
	
	public static void printArray(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
