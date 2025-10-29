// Time Complexity : O(n) as we need to visit all nodes to check the bst violation
// Space Complexity : O(n) is the space occupied on the recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Validate Binary Search Tree
 * */

/*
 * Approach: Inorder Traversal - In this approach we use boolean based conditional recursion and global reference of prev.
 * At any point, if value of previous becomes greater than or equal to the root value, it means
 * the node is violating the bst property and we return false.
 * */

public class ValidateBinarySearchTree_usingInorderTraversal3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBinarySearchTree_usingInorderTraversal2 validateBinarySearchTree = new ValidateBinarySearchTree_usingInorderTraversal2();
        System.out.println(validateBinarySearchTree.isValidBST(root));
    }

    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root) {
        // base case
        if (root == null) return true;

        // logic
        if (!helper(root.left)) return false;

        if (prev != null && prev.val >= root.val) {
            return false;
        }

        prev = root;
        return helper(root.right);
    }
}
