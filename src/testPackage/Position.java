package testPackage;

import java.util.HashSet;

public class Position {
	public int row;
	public int col;
	
	public Position(int row, int col) throws Exception
	{
		if((row >= 0 && col >= 0) && (row <= 7 && col <= 7))
		{
			this.row = row;
			this.col = col;
		}
		else
		{
			throw new Exception("Invalid");
		}
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Position pos = (Position)obj;
		return this.row == pos.row && this.col == pos.col;
	}
	
	@Override
	public int hashCode()
	{
		return row + col;
	}
	
	public static Position getPossiblePos(Position pos1, Position pos2)
	{
		HashSet<Position> set = new HashSet<Position>();
		
		try {
			Position newPos = new Position(pos1.row - 2, pos1.col - 1);
			set.add(newPos);
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos1.row - 1, pos1.col - 2);
			set.add(newPos);
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos1.row - 2, pos1.col + 1);
			set.add(newPos);
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos1.row - 1, pos1.col + 2);
			set.add(newPos);
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos1.row + 1, pos1.col - 2);
			set.add(newPos);
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos1.row + 2, pos1.col - 1);
			set.add(newPos);
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos1.row + 1, pos1.col + 2);
			set.add(newPos);
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos1.row + 2, pos1.col + 1);
			set.add(newPos);
		}
		catch (Exception e) {}
		
		//=========================================================
		
		try {
			Position newPos = new Position(pos2.row - 2, pos2.col - 1);
			
			if(set.contains(newPos))
			{
				System.out.println("position found! Row: " + newPos.row + " Col: " + newPos.col);
				return newPos;
			}
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos2.row - 1, pos2.col - 2);
			
			if(set.contains(newPos))
			{
				System.out.println("position found! Row: " + newPos.row + " Col: " + newPos.col);
				return newPos;
			}
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos2.row - 2, pos2.col + 2);
			
			if(set.contains(newPos))
			{
				System.out.println("position found! Row: " + newPos.row + " Col: " + newPos.col);
				return newPos;
			}
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos2.row - 1, pos2.col + 2);
			
			if(set.contains(newPos))
			{
				System.out.println("position found! Row: " + newPos.row + " Col: " + newPos.col);
				return newPos;
			}
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos2.row + 1, pos2.col - 2);
			
			if(set.contains(newPos))
			{
				System.out.println("position found! Row: " + newPos.row + " Col: " + newPos.col);
				return newPos;
			}
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos2.row + 2, pos2.col - 1);
			
			if(set.contains(newPos))
			{
				System.out.println("position found! Row: " + newPos.row + " Col: " + newPos.col);
				return newPos;
			}
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos2.row + 1, pos2.col + 2);
			
			if(set.contains(newPos))
			{
				System.out.println("position found! Row: " + newPos.row + " Col: " + newPos.col);
				return newPos;
			}
		}
		catch (Exception e) {}
		
		try {
			Position newPos = new Position(pos2.row + 2, pos2.col + 1);
			
			if(set.contains(newPos))
			{
				System.out.println("position found! Row: " + newPos.row + " Col: " + newPos.col);
				return newPos;
			}
		}
		catch (Exception e) {}
		
		System.out.println("No possible position for the knight");
		return null;
	}
}
