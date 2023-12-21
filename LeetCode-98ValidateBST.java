//approach-1 just do the In-order traversal first, and input the valid BST. 
//we're just learning here in-order traversal, which gives us Ascending order of all nodes. 

public class Solution
{
	public boolean isValidBST(TreeNode root)
	{
		inOrder(root);
		
		return true; //cause we are inputting valid BST only. 
	}
	
	private void inOrder(TreeNode root)
	{
		//base case
		if(root == null) return;
		
		//recursive calls to left subtree
		inOrder(root.left);
		
		//print the root just to dictate it's inorder
		System.out.println(root.val);
		
		//recursive calls to right subtree
		inOrder(root.right);
		
	}
}

//in the above case, if we change the line 22 and keep it on line 17, it will be pre-order but still give us true, and same way if we keep it to line 26, it will be post order and no chnage in answer. 
//cause in every traversal , every ode will be touched, just the order will be different. 
//TC - touching all nodes of the tree - O(n)
//SC- recursive stack that's being used behind the scenes. - O(height of the tree) - o(h)






//approach-2 - use the above code, but add validation for the BST. 
//validation - root.left < root && root < root.right!
 
 public class Solution
{
	boolean isValid;
	public boolean isValidBST(TreeNode root)
	{
		isValid = inOrder(root);
		
		return isValid; //cause we are inputting valid BST only. 
	}
	
	private void inOrder(TreeNode root)
	{
		//base case
		if(root == null) return true;
		
		//recursive calls to left subtree
		inOrder(root.left);
		
		//print the root just to dictate it's inorder
		//System.out.println(root.val);
		//condition check after visiting the left tree - 
		if(root.left != null && root < root.left)
		{
			isValid = false;
		}
		
		//recursive calls to right subtree
		inOrder(root.right);
		
		return isValid;
	}
}


//approach -3 , put inorder with return type as boolean
//if left is false, then we dont need to g on right and check, if we found the breach at left tree, we simply return from there. 
class Solution {
    TreeNode prev;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {

		return inOrder(root);

	}
	
	private boolean inOrder(TreeNode root)
	{
		boolean left = inOrder(root.left);
		
		if(prev != null && prev.val >= root.val)
		{
			return false;
		}
		prev = root;
		boolean right = true;
		if(left)
		{
			right = inOrder(root.right);
		}
		return right && left;
	}
}

//approach -4
//check if rbreach happened on left, if so return false from there. else return root.right's result, as left sub-tree always turned out true. 

class Solution{
TreeNode prev;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {

		return inOrder(root);

	}
	
	private boolean inOrder(TreeNode root)
	{
		//base case
		if(root == null) return true;
		
		if(inOrder(root.left) == false) return false;
		
		//comes here only if left was true. 
		if(prev != null && prev.val >= root.val)
		{
			return false;
		}
		prev = root;
		
		return inOrder(root.right);
	}

}


//if I do pre-rder traversal for the above code, where I put the condition check right after base case, it will not work,cause we have to have root value to compare the left and right child's value with root's val. 