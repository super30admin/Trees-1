// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }

    private void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);

        if(prev != null && prev.val >= root.val){
            flag = false;
        }

        prev = root;
        helper(root.right);
    }
}