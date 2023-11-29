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
    boolean flag;

    public boolean isValidBST(TreeNode root) {

        this.flag = true;

        validate(root);

        return flag;
    }

    private void validate(TreeNode root) {

        if(root == null) return;
        if(!flag) return;

        validate(root.left);

        if(prev != null && prev.val >= root.val) {
            flag = false;
            return;
        }

        prev = root;

        validate(root.right);
    }
}