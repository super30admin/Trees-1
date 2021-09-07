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
 // TC : O(n) & SC : O(h)
 //All values on the left sub tree must be less than parent and parent's parent, and all values on the right sub tree must be 
 //greater than parent and parent's parent. So we just check the boundaries for each node.
class Solution {
    public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
}
public boolean isValidBST(TreeNode p, double min, double max){
    if(p==null) 
        return true;
    if(p.val <= min || p.val >= max)
        return false;
    return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
    }
}