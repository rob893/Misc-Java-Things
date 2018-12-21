package testPackage;

import java.util.LinkedList;

import javax.management.openmbean.InvalidKeyException;

public class MyHashMap 
{
	@SuppressWarnings("unchecked")
	LinkedList<MapNode>[] map = new LinkedList[10];
	
	public MyHashMap()
	{
		for(int i = 0; i < map.length; i++)
		{
			map[i] = new LinkedList<MapNode>();
		}
	}
	
	public void put(String key, int value)
	{
		int index = key.hashCode() % map.length;
		System.out.println(index);
		if(map[index].size() == 0) //No collision
		{
			map[index].add(new MapNode(key, value));
		}
		else //we have a collision
		{
			System.out.println("Collision!");
			for(MapNode node : map[index]) //loop through list to see if the key is already there.
			{
				if(node.key.equals(key)) //If the key exists in the list, update it and return.
				{
					node.value = value;
					return;
				}
			}
			
			map[index].add(new MapNode(key, value)); //add key if it does not exist in the list
		}
	}
	
	public int get(String key)
	{
		int index = key.hashCode() % map.length;
		
		for(MapNode node : map[index])
		{
			if(node.key.equals(key))
			{
				return node.value;
			}
		}
		
		throw new InvalidKeyException("The given key does not exist in the map!");
	}
	
	public boolean containsKey(String key)
	{
		int index = key.hashCode() % map.length;
		
		for(MapNode node : map[index])
		{
			if(node.key.equals(key))
			{
				return true;
			}
		}
		
		return false;
	}
	
	private class MapNode
	{
		private String key;
		private int value;
		
		public MapNode(String key, int value)
		{
			this.key = key;
			this.value = value;
		}
	}
}
