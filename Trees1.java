package LeetCode;

public class Trees1 {
	//Validate a BST
	
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	 
	class Solution {
	    TreeNode prev = null;
	    public boolean isValidBST(TreeNode root) {
	       return helper(root);
	        
	    }
	    private boolean helper(TreeNode root){
	        if(root == null)
	            return true;
	        
	        if(helper(root.left) == false) return false;
	        if(prev!=null && root.val <= prev.val) return false;
	        prev = root;
	        return helper(root.right);
	    }
	}
	
	
	
	//Approach 2
		  public boolean helper(TreeNode node, long floor, long ceil) {
		      
		      if(node == null)
		          return true;
		      
		      if(node.val >=ceil || node.val <= floor)
		          return false;
		      
		      return helper(node.left, floor, node.val) && helper(node.right, node.val, ceil);

		  }

		  public boolean isValidBST(TreeNode root) {
		      if(root == null)
		          return true;
		      
		    return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
		}
	
	/*
	TC - O(n)
	SC - O(h)
	*/
	
	
	
	

}
