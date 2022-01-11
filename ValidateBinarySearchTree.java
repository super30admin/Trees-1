package trees1;

public class ValidateBinarySearchTree {
	//Time Complexity : O(n), where n is the height of tree
	//Space Complexity : O(n), Implicit stack for recursion
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : Two Pointer approach
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
		 
	TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return isInorder(root);
    }
    
    private boolean isInorder(TreeNode root) {
        if(root == null)
            return true;
        
        if(!isInorder(root.left))
            return false;
        
        if(prev != null && prev.val >= root.val)
            return false;
        prev = root;
        
        return isInorder(root.right);
    }
}
