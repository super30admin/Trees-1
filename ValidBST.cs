/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    bool result;
    TreeNode prev;
    public bool IsValidBST(TreeNode root) {
        result = true;
        helper(root);
        return result;        
    }

    private void helper(TreeNode root)
    {
        if(root == null || !result) return;
        helper(root.left);
        if(prev != null && prev.val >= root.val)
        {
            result = false;
        }
        prev = root;
        helper(root.right);
    }
}
