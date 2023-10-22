// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    boolean flag;
    TreeNode prev;
    private void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        if(prev!=null && prev.val >= root.val)
            flag = false;
        prev = root;
        if(flag)
            helper(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        flag = true;
        prev = null;
        helper(root);
        return flag;
    }
}