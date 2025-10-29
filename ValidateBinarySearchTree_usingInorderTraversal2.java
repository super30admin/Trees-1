// Time Complexity : O(n) as we need to visit all nodes to check the bst violation
// Space Complexity : O(n) is the space occupied on the recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Validate Binary Search Tree
 * */

/*
 * Approach: Inorder Traversal - In this approach we use void based conditional recursion and global reference of prev.
 * At any point, if value of previous becomes greater than or equal to the root value, it means
 * the node is violating the bst property and we return false.
 * */

public class ValidateBinarySearchTree_usingInorderTraversal2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBinarySearchTree_usingInorderTraversal3 validateBinarySearchTree = new ValidateBinarySearchTree_usingInorderTraversal3();
        System.out.println(validateBinarySearchTree.isValidBST(root));
    }

    TreeNode prev = null;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return flag;
    }

    private void helper(TreeNode root) {
        // base case
        if (root == null) return;

        // logic
        if (flag) helper(root.left);

        if (prev != null && prev.val >= root.val) {
            flag = false;
        }

        prev = root;
        if (flag) helper(root.right);
    }
}
