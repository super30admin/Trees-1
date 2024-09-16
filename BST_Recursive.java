// Time Complexity : O(n), n=number of nodes
// Space Complexity : O(H), H=Height of the tree
// Did this code successfully run on Leetcode : Yes
class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root) {
        if(root == null) return true;
        
        if(inorder(root.left) == false) return false;
        if(prev != null && prev.val >= root.val)
            return false;
        prev = root;
        return inorder(root.right);
    }
}