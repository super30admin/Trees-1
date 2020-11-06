class TreeNode 
{ 
	int data; 
	TreeNode left;
	TreeNode right; 

	public TreeNode(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

public class ValidBST
{ 
	//Root of the Binary Tree 
	TreeNode root; 
	
	boolean isBST() { 
		return check(root, Integer.MIN_VALUE, 
							Integer.MAX_VALUE); 
	} 

	boolean check(TreeNode node, int min, int max) 
	{ 
		if (node == null) 
			return true; 

		if (node.data < min || node.data > max) 
			return false; 

		return (check(node.left, min, node.data-1) && 
				check(node.right, node.data+1, max)); 
	} 

	/* Driver program to test above functions */
	public static void main(String args[]) 
	{ 
		ValidBST tree = new ValidBST(); 
		tree.root = new TreeNode(4); 
		tree.root.left = new TreeNode(2); 
		tree.root.right = new TreeNode(5); 
		tree.root.left.left = new TreeNode(1); 
		tree.root.left.right = new TreeNode(3); 

		if (tree.isBST()) 
			System.out.println("Valid BST"); 
		else
			System.out.println("Not a valid BST"); 
	} 
} 