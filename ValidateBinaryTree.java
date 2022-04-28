// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class ValidateBinaryTree {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        return dfs(root);
    }
    
    private boolean dfs(TreeNode root) {
        
        if(root == null) return true;
        
        boolean left = dfs(root.left);
        if(prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        
        boolean right = dfs(root.right);
        return left && right;
    }
}