// TC : O(n)
// SC : O(1)
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
// Solution 1 -> Having global Prev node.

// class Solution {
// TreeNode prev;
// boolean breach;
// public boolean isValidBST(TreeNode root) {
// this.breach = false;
// helper(root);

// return !breach;
// }

// private void helper(TreeNode node) {
// //Base case
// if(node == null) return;

// //Left
// helper(node.left);

// //Parent
// if(prev != null && node.val <= prev.val) {
// breach = true;
// return;
// }
// prev = node;

// //Right
// helper(node.right);

// }
// }

// Solution 2 - Maintaining a range
// TC - O(n)
// SC - O(1)
// class Solution {

// boolean breach;
// public boolean isValidBST(TreeNode root) {
// this.breach = false;
// breach = helper(root, null, null);

// return !breach;
// }

// private boolean helper(TreeNode node, Integer min, Integer max) {

// //Base case
// if(node == null) return false;

// //Left
// helper(node.left, min, node.val);

// //Parent
// if(( min != null && node.val <= min) || ( max != null && node.val >= max)) {
// breach = true;
// return breach;
// }

// //Right
// helper(node.right, node.val, max);

// return breach;

// }
// }

// Solution 3 - Just checking prev node value at inorder and postorder level
// TC - O(n)
// SC - O(1)
class Solution {
    TreeNode prev;
    boolean breach;

    public boolean isValidBST(TreeNode root) {
        this.breach = false;
        helper(root);

        return !breach;
    }

    private void helper(TreeNode node) {
        // Base case
        if (node == null)
            return;

        // Left
        helper(node.left);

        // Parent
        if (prev != null && node.val <= prev.val) {
            breach = true;
            return;
        }
        prev = node;

        // Right
        helper(node.right);

        if (prev != null && node.val > prev.val) {
            breach = true;
            return;
        }

    }
}