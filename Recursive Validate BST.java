// Time complexity  0(n) - visting each node in tree
// space complexity 0(h) - Height of the Tree.
// Code successfully executed in leecode

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return Valid(root,null,null);
        
    }
    private boolean Valid(TreeNode root, Integer max, Integer min){
        // base case
        
        if(root == null) return true;
        
        if(max!= null && root.val >= max) return false;
        if(min!= null && root.val <= min) return false;
        
        
        return  Valid(root.left, root.val, min ) && Valid(root.right, max , root.val);
        
        
    }
}