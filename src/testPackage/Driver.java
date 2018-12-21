package testPackage;


public class Driver 
{
	public static void main(String[] args) 
	{
		//int[] values = {5, 4, 7, 8, 2, 9};
		int[] vals = { 2, 1, 3, 6, 9, 0 };
		
		GarbageSort.printArray(vals);
		GarbageSort.sort(vals);
		GarbageSort.printArray(vals);
		
//		BSTree tree = BSTree.buildTree(values);
//		System.out.println(tree.getTreeDiameter());
//		tree.balanceTree();
//		System.out.println(tree.getTreeDiameter());
	}
}
