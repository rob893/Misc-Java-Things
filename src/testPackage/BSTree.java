package testPackage;

import java.security.InvalidParameterException;


public class BSTree extends Tree
{
	public BSTree(TreeNode root) 
	{
		super(root);
	}
	
	@Override
	void insert(int value, TreeNode root)
	{
		if(contains(value, root))
		{
			throw new InvalidParameterException("This tree cannot contain duplicates! " + value + " is a duplicate value!");
		}
		if(value >= root.data)
		{
			if(root.right == null)
			{
				root.right = new TreeNode(value);
			}
			else
			{
				insert(value, root.right);
			}
		}
		else
		{
			if(root.left == null)
			{
				root.left = new TreeNode(value);
			}
			else
			{
				insert(value, root.left);
			}
		}
	}
	
	@Override
	boolean contains(int value, TreeNode root)
	{
		if(value == root.data)
		{
			return true;
		}
		
		if(value < root.data)
		{
			if(root.left == null)
			{
				return false;
			}
			else
			{
				return contains(value, root.left);
			}
		}
		else
		{
			if(root.right == null)
			{
				return false;
			}
			else
			{
				return contains(value, root.right);
			}
		}
	}
	
	public boolean checkBST()
	{
		return checkBST(this.root);
	}
	
	boolean checkBST(TreeNode root)
	{
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	boolean checkBST(TreeNode root, int min, int max)
	{
		if(root == null)
		{
			return true;
		}
		
		if(root.data > max || root.data < min)
		{
			return false;
		}
		
		return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
	}
	
	public static BSTree buildTree(int[] values)
	{
		if(values == null || values.length < 1)
		{
			throw new InvalidParameterException("The passed in array needs at least 1 value!");
		}
		
		TreeNode root = new TreeNode(values[0]);
		BSTree tree = new BSTree(root);
		
		if(values.length > 1)
		{
			for(int i = 1; i < values.length; i++)
			{
				tree.insert(values[i]);
			}
		}
		
		return tree;
	}
}
