/*
Run Time complexity - O(N) where N is the number of node in the tree
Space Complexity - O(H) where H is the height of the tree
*/

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
        return check(root, null,null);
    }
    public boolean check(TreeNode root, Integer min, Integer max)
    {
        if(root==null)
            return true;
        if((min!=null && root.val<=min) || (max!=null && root.val>=max))
            return false;
        return check(root.left,min,root.val) && check(root.right,root.val,max);
    }
    
}
