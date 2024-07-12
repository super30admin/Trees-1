// Problem1.java

public class Problem1 {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Solution {
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        private boolean helper(TreeNode root, Integer min, Integer max) {
            // Base case: if the node is null, it is a valid BST
            if (root == null) return true;

            // If the current node's value is less than or equal to the min value, Not a BST
            if (min != null && root.val <= min) {
                return false;
            }

            // If the current node's value is greater than or equal to the max value, Not a BST
            if (max != null && root.val >= max) {
                return false;
            }

            // Recursively check the left subtree with updated max value as current node's value
            if (!helper(root.left, min, root.val)) return false;

            // Recursively check the right subtree with updated min value as current node's value
            return helper(root.right, root.val, max);
        }
    }

    private static TreeNode createNode(int val, TreeNode left, TreeNode right) {
        return new TreeNode(val, left, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Valid BST
        TreeNode tree1 = createNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Tree 1 is a valid BST: " + solution.isValidBST(tree1));  // Expected output: true

        // Test case 2: Invalid BST
        TreeNode leftSubtree = createNode(1, null, null);
        TreeNode rightSubtree = createNode(4, new TreeNode(3), new TreeNode(6));
        TreeNode tree2 = createNode(5, leftSubtree, rightSubtree);
        System.out.println("Tree 2 is a valid BST: " + solution.isValidBST(tree2));  // Expected output: false
    }
}
