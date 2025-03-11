import javax.swing.tree.TreeNode;

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

 /*
  * TC - O(n), each node is visited once
    SC - O(n), height of the tree which can go upto n nodes

    Explaination - check each node if it fits between the range
  */

class Solution {
        public boolean isValidBST(TreeNode root) {
            return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean validate(TreeNode node, long min, long max) {

            if (node == null) return true;

            if (node.val <= min || node.val >= max) return false;

            boolean leftValid = validate(node.left, min, node.val);

            boolean rightValid = validate(node.right, node.val, max);

            return leftValid && rightValid;
        }
    }