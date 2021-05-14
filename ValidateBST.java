// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We do an In-Order Traversal of the Tree, 
    and store the previous element in a globl scope.
    The base condition being if that element is larger than the previous.
*/

class Solution {
    
    TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return validate(root);
    }
    
    public boolean validate(TreeNode root){
        if (root == null) return true;
        boolean left = validate(root.left);
        if (prev!=null && prev.val>=root.val) return false;
        prev = root;
        boolean right = validate(root.right);
        return left && right;
    }
}