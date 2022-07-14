// T.C :O(N)
// S.C : O(H), H is the height of recursive stack

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
        if(root == null) return true;
        return helper(root,null,null);
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        
        if(min!= null && root.val<=min) return false;
        if(max!= null && root.val>=max) return false;
        
        boolean case1 = helper(root.left,min, root.val);
        boolean case2 = helper(root.right,root.val, max);
        
        return case1 && case2;
        
    }
    
}