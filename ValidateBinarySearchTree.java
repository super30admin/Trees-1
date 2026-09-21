// Use DFS with a valid min and max range for each node.
// Ensure every node is strictly within its range, then update the range for the left and right subtrees.
// Use Long bounds to safely handle Integer.MIN_VALUE and Integer.MAX_VALUE.

// Time Complexity: O(n)
// Space Complexity: O(h) — recursion stack, where h is tree height.
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return validate(node.left, min, node.val)
                && validate(node.right, node.val, max);
    }
}

