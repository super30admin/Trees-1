/* Time Complexity : O(n)
 * 	n - size of the tree */
/* Space Complexity : O(1) */

// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root){
        if(root == null) return true;
        boolean left = helper(root.left);
        if(left == false) return false;//conditional recurssion
        if(prev != null && prev.val >= root.val){
           return false;
        }
        prev = root;
        boolean right = helper(root.right);

        return  right;
    }
}