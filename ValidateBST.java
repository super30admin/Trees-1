package Trees1;
// Time Complexity : O(n)
// Space Complexity : O(h) (recursion stack)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class ValidateBST {
    TreeNode prev = null;
    boolean flag=true;
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return flag;
    }
    private void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        if(!flag)
            return;
        if(prev != null && prev.val >= root.val){
            flag=false;
            return;
        }
        prev = root;
        helper(root.right);
    }
}
