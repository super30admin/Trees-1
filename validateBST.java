//TC- O(N)
//TC- O(1)

class Solution {
    // Variable to keep track of the previous TreeNode in the inorder traversal
    TreeNode prev;

    // Helper function to perform inorder traversal and validate the BST property
    private boolean traversal(TreeNode root) {
        // Base case: if the node is null, return true (valid subtree)
        if (root == null) return true;

        // Recursively traverse the left subtree
        boolean left = traversal(root.left);

        // If the previous node exists and its value is greater than or equal to the current node's value, it's not a valid BST
        if (prev != null && prev.val >= root.val) return false;

        // Update the previous node to the current node
        prev = root;

        // Recursively traverse the right subtree
        boolean right = traversal(root.right);

        // Return true only if both left and right subtrees are valid
        return left && right;
    }

    // Public method to determine if a binary tree is a valid BST
    public boolean isValidBST(TreeNode root) {
        // Initialize the previous node as null
        prev = null;

        // Start the inorder traversal and validation from the root
        return traversal(root);
    }
}
