// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    boolean result;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        result = true;
        // call the recursive function
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root){
        // base condition
        if(root == null) return;
        // keep pushing the left elements inside the recursive stack
        inorder(root.left);
        // recursive stack pop
        // check with previous root value
        if(prev != null && prev.val >= root.val) {
            // return false if current root is less than or equal to the previous root
            result = false;
            return;
        }
        // update previous root
        prev = root;
        // keep pushing the right elements inside the recursive stack
        inorder(root.right);
    }
}