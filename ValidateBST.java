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
        //Initializing min and max values
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return isValidBst(root, min, max);
    }
    
    private boolean isValidBst(TreeNode node, long min, long max){
        
        if(node == null){
            return true;
        }
        // If node value is not in range of min and max, return false
        if(node.val <= min || node.val >= max){
            return false;
        }
        
        // If we traverse left in tree, max would be current node val and min will be same
        // If we traverse right in tree, min would be current node val and max will be same
        return isValidBst(node.left, min, node.val) && isValidBst(node.right, node.val, max);
        
    }
    
}