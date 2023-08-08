// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ValidateBinarySearchTree {
    TreeNode prev; // To keep track of the previously visited node during traversal

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorderTraversal(root);
    }

    private boolean inorderTraversal(TreeNode node) {
        if (node == null) {
            return true;
        }

        // Traverse the left subtree
        if (!inorderTraversal(node.left)) {
            return false;
        }

        // Check if the current node's value is greater than the previous visited node's value
        if (prev != null && node.val <= prev.val) {
            return false;
        }
        prev = node; // Update prev to the current node

        // Traverse the right subtree
        return inorderTraversal(node.right);
    }
}