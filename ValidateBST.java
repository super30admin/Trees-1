// Time Complexity : O(n) 
// Space Complexity : O(H) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class TreeNode {
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

public class ValidateBST {
    // Public method to determine if the binary tree is a valid BST
    public boolean isValidBST(TreeNode root) {
        // Call the helper method with initial min and max values
        return checkvalid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper method to validate the BST
    public boolean checkvalid(TreeNode root, long min, long max) {
        // Base case: An empty tree is a valid BST
        if (root == null) {
            return true;
        }

        // If current node's value is out of the valid range, return false
        if (root.val >= max || root.val <= min) {
            return false;
        }

        // Recursively validate the left subtree and right subtree
        // Left subtree: Update max to the current node's value
        // Right subtree: Update min to the current node's value
        return checkvalid(root.left, min, root.val) && checkvalid(root.right, root.val, max);
    }

    public static void main(String[] args) {
        // Example usage of the ValidateBST class
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBST solution = new ValidateBST();
        boolean result = solution.isValidBST(root);
        
        System.out.println("Is it VALID BST : " + result);
    }
}