// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create a new method validate, this will have parameters for left and right nodes
//We will check the current node with left and right child's value, it should satisfy the BST order
//We will recursively call the left and right subtree
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
    public boolean isValidBST(TreeNode root) {
        
        return validate(root, null, null);
    }
    boolean validate(TreeNode root, Integer low, Integer high){
        if(root == null)
            return true;
        int value = root.val;
        if(low != null)
            if(low >= value)
                return false;
        if(high != null)
            if(high <= value)
                return false;
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }
}