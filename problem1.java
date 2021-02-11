package tree;
//Time complexity : O(n) 
//Space complexity : O(n) 
//Did this code successfully run on Leetcode : YES
//Any problem you faced while coding this : None

public class problem1 { 
	public boolean validate(TreeNode root, Integer low, Integer high) {
    // Empty trees are valid BSTs.
    if (root == null) {
        return true;
    }
    // The current node's value must be between low and high.
    if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
        return false;
    }
    // The left and right subtree must also be valid.
    return validate(root.right, root.val, high) && validate(root.left, low, root.val);
}
public boolean isValidBST(TreeNode root) {
    return validate(root, null, null);
 }
}
