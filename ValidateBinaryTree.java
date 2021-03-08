/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(h)   (where h -> height of the tree)
    
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
    private boolean validate(TreeNode root, Integer max, Integer min){
        if(root == null)
            return true;

        // If it violates the BST property for left subtree
        if(max != null && root.val >= max)
            return false;
        
        // If it violates the BST property for right subtree
        if(min != null &&  root.val <= min)
                return false;

        return validate(root.left, root.val, min) && validate(root.right, max, root.val);
    }
}