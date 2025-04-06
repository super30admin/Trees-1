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
class BinarySearchTree {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }

    private void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        if(prev !=null && prev.val >=root.val){
            flag = false;
        }
        prev = root;
        helper(root.right);x
    }
}