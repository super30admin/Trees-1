// Time Complexity : O(V)- V is the number of vertices
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        /**
         * We will fill all the values starting from root and going to its leftmost
         * child in a stack. After that we start retreving the values and start
         * comparing them to their immediate neighbour(I.e Inorder Traversal of BST
         * gives Sorted Array) If the conditions doesn't meet we return false.
         */
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode curr = stack.pop();

            if (prev != null && prev.val >= curr.val) {
                return false;
            }

            prev = curr;

            root = curr.right;
        }

        return true;

    }
}