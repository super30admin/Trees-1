/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Time Complexity is O(n)
// Space Complexity is O(h) => O(logn) that is height of three
class Solution {
    TreeNode lastValue = null;
    boolean isBST;

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        isBST = true;
        inorder(root);

        return isBST;

    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (lastValue != null && lastValue.val >= root.val) {
            isBST = false;
        }

        lastValue = root;
        inorder(root.right);

    }
}