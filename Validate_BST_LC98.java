//Leetcode Problem 98, Validating a Binary Search Tree. Ran successfully on Leetcode
// @ Time Complexity - O(N), Space Complexity - O(N)
package Validate_BST_LC98;
//Definition for a binary tree node.


public class Validate_BST_LC98 {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	    TreeNode right;
	     TreeNode(int x) 
	     { 
	    	 val = x; 
	    	 }
	     
	 }
	static TreeNode root; 
	
	public boolean isValidBST(TreeNode root) 
	{
    return isValid(root, null, null);
    
}

private boolean isValid(TreeNode root, Integer max, Integer min)
{
    //Check for the edge cases 
      if(root==null)
      {
          return true;
      }
    
    if(max!=null && root.val>=max)
    {
        return false;
    }
    
    if(min!=null && root.val<=min)
    {
        return false;
    }
    
    return isValid(root.left,root.val,min) && isValid(root.right,max,root.val);
}

public static void main(String args[]) 
{ 
	Validate_BST_LC98 tree = new Validate_BST_LC98(); 
    tree.root = new TreeNode(4); 
    tree.root.left = new TreeNode(2); 
    tree.root.right = new TreeNode(5); 
    tree.root.left.left = new TreeNode(1); 
    tree.root.left.right = new TreeNode(3); 

    if (tree.isValidBST(root)) 
        System.out.println("IS BST"); 
    else
        System.out.println("Not a BST"); 
} 

}
