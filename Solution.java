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


// We check for left and right child here
// Left child = Less than or equal to the root the node 
// right child = value ranges from root to infinity


class Solution {
    public boolean isValidBST(TreeNode root) {
        // Node Validation
        return validate(root, null, null); // recursive function call
 
    }
    private boolean validate(TreeNode node, Integer low, Integer high){
        if (node == null) return true; // leaf node
        
        if (( low != null  &&  node.val <= low) || (high != null && node.val >= high)) {
            
            return false;

        }
          
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
        
    }
}
