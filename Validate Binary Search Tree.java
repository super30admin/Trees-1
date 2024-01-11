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
 //TC: O(n)
 //Sc: O(h)
 class Solution {
    TreeNode prev;
    Boolean flag;

    public boolean isValidBST(TreeNode root) {
            this.flag = true;
            inorder(root);
            return flag;    
    }

    private void inorder(TreeNode root)
    {
        if(root == null) return;
        //logic
        inorder(root.left);
        if(prev != null && prev.val >= root.val) this.flag = false;
        prev = root;
        inorder(root.right);
    }
}