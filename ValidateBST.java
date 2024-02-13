// Time complexity: O(n)
// Space complexity: Recursion stack O(h) where h = height of the tree (max recursion calls at one point)
// Approach: Use inorder traversal and compare with the last element

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leftResult = isValidBST(root.left);
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;
        boolean rightResult = leftResult && isValidBST(root.right);

        return leftResult && rightResult;
    }
}