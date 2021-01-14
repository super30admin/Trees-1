//Time complexity = o(n)
//Space complexity = o(1)

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
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        return inOrder(root);
    }
    private boolean inOrder(TreeNode root)
    {
        if(root == null) return true;       
        if (inOrder(root.left) == false) return false;
        if(prev != null && prev.val >= root.val) return false;
        prev = root;
        return inOrder(root.right);
    }
}