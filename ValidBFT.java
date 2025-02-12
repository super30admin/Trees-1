//Space Complexity: O(H) H is the height / O(log N) Blanced Tree
//Time Complexity: O(N)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        // Start validation with the entire valid range for a BST
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // Base case: If we reach a null node, it's valid
        if (node == null) return true;

        // If the current node value is out of the valid range, return false
        if (node.val <= min || node.val >= max) return false;

        // Recursively validate the left and right subtrees
        // Left subtree must have values < node.val
        // Right subtree must have values > node.val
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}


