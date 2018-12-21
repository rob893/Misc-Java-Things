package testPackage;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree 
{
	protected TreeNode root;
	
	
	public Tree(TreeNode root)
	{
		this.root = root;
	}
	
	public TreeNode getRoot()
	{
		return root;
	}
	
	public void insert(int value)
	{
		insert(value, this.root);
	}
	
	void insert(int value, TreeNode root)
	{
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			root = queue.remove();
			
			if(root.left == null)
			{
				root.left = new TreeNode(value);
				break;
			}
			else
			{
				queue.add(root.left);
			}
			
			if(root.right == null)
			{
				root.right = new TreeNode(value);
				break;
			}
			else
			{
				queue.add(root.right);
			}
		}
	}
	
	public boolean contains(int value)
	{
		return contains(value, this.root);
	}
	
	boolean contains(int value, TreeNode root)
	{
		if(value == root.data)
		{
			return true;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			root = queue.remove();
			
			if(root.data == value)
			{
				return true;
			}
			
			if(root.left != null)
			{
				queue.add(root.left);
			}
			
			if(root.right != null)
			{
				queue.add(root.right);
			}
		}
		
		return false;
	}
	
	public boolean checkIsBalanced()
	{
		return checkIsBalanced(this.root);
	}
	
	boolean checkIsBalanced(TreeNode root)
	{
		int diff = getTreeDepth(root.left) - getTreeDepth(root.right);
		if(diff < -1 || diff > 1)
		{
			return false;
		}
		
		return true;
	}
	
	public int getTreeDepth()
	{
		return getTreeDepth(this.root);
	}
	
	int getTreeDepth(TreeNode root)
	{
		int[] numNodesHolder = new int[1];
		numNodesHolder[0] = root == null ? 0 : 1;
		getTreeDepth(root, numNodesHolder);
		
		return numNodesHolder[0];
	}
	
	int getTreeDepth(TreeNode root, int[] numNodesHolder)
	{
		if(root == null)
		{
			return 0;
		}
		
		int leftDepth = getTreeDepth(root.left, numNodesHolder);
		int rightDepth = getTreeDepth(root.right, numNodesHolder);
		int deeperPath = Math.max(leftDepth, rightDepth);
		int cumalativeResult = deeperPath + 1;
		numNodesHolder[0] = Math.max(numNodesHolder[0], cumalativeResult);
		
		return cumalativeResult;
	}
	
	public int getTreeDiameter()
	{
		return getTreeDiameter(this.root);
	}
	
	int getTreeDiameter(TreeNode root)
	{
		int[] numHolder = new int[1];
		numHolder[0] = root == null ? 0 : 1;
		getTreeDiameter(root, numHolder);
		
		return numHolder[0];
	}
	
	int getTreeDiameter(TreeNode root, int[] numholder)
	{
		if(root == null)
		{
			return 0;
		}
		
		int lSize = getTreeDiameter(root.left, numholder);
		int rSize = getTreeDiameter(root.right, numholder);
		int cumulative = 1 + Math.max(lSize, rSize);
		
		numholder[0] = Math.max(numholder[0], 1 + lSize + rSize);
		
		return cumulative;
	}
	
	public void balanceTree()
	{
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode current = this.root;
		
		while(current != null || !stack.isEmpty())
		{
			if(current != null)
			{
				stack.push(current);
				current = current.left;
			}
			else 
			{
				current = stack.pop();
				sortedList.add(current.data);
				current = current.right;
			}
		}
		
		this.root = balanceTree(sortedList, 0, sortedList.size() - 1);
		
		if(!checkIsBalanced())
		{
			System.out.println("Something went wrong! The tree is not balanced!");
		}
	}
	
	TreeNode balanceTree(ArrayList<Integer> sortedList, int start, int end)
	{
		if(start > end)
		{
			return null;
		}
		
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(sortedList.get(mid));
		root.left = balanceTree(sortedList, start, mid - 1);
		root.right = balanceTree(sortedList, mid + 1, end);
		
		return root;
	}
	
	public void printInOrder()
	{
		printInOrder(this.root);
	}
	
	void printInOrder(TreeNode root)
	{
		if(root.left != null)
		{
			printInOrder(root.left);
		}
		
		System.out.println(root.data);
		
		if(root.right != null)
		{
			printInOrder(root.right);
		}
	}
	
	public void printPreOrder()
	{
		printInOrder(this.root);
	}
	
	void printPreOrder(TreeNode root)
	{
		System.out.println(root.data);
		
		if(root.left != null)
		{
			printInOrder(root.left);
		}
		
		if(root.right != null)
		{
			printInOrder(root.right);
		}
	}
	
	public void printPostOrder()
	{
		printInOrder(this.root);
	}
	
	void printPostOrder(TreeNode root)
	{
		if(root.left != null)
		{
			printInOrder(root.left);
		}
		
		if(root.right != null)
		{
			printInOrder(root.right);
		}
		
		System.out.println(root.data);
	}
	
	public void printOrderLevel()
	{
		printOrderLevel(this.root);
	}
	
	void printOrderLevel(TreeNode root)
	{
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			root = queue.remove();
			System.out.println(root.data);
			
			if(root.left != null)
			{
				queue.add(root.left);
			}
			
			if(root.right != null)
			{
				queue.add(root.right);
			}
		}
	}
	
	public static Tree buildTree(int[] values) //TODO: Turn into factory or something
	{
		if(values == null || values.length < 1)
		{
			throw new InvalidParameterException("The passed in array needs at least 1 value!");
		}
		
		TreeNode root = new TreeNode(values[0]);
		Tree tree = new Tree(root);
		
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
