public class Solution {
    bool isValidBinaryTree = true;
    TreeNode prev = null;
        
    public bool IsValidBST(TreeNode root) {
        helper(root);
        return isValidBinaryTree;
        
    }
    void helper(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        helper(root.left);
        if(prev!=null && prev.val >= root.val)
        {
            isValidBinaryTree = false;
        }
        prev = root;
        helper(root.right);
    }
}