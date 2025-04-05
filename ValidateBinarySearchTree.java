//Approach -1

/**
 * Performs an inorder traversal, ensuring nodes appear in strictly increasing order.
 * Compares each node with the previous one to validate the BST property.
 * TC: O(n), SC: O(h) - where h is the height of the tree (recursive call stack).
 */
public class ValidateBinarySearchTree {
    boolean flag;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;

    }

    private void helper(TreeNode root) {
        //base case
        if (root == null || !flag) return;

        helper(root.left);

        if (prev != null && prev.val >= root.val) {
            flag = false;
        }

        prev = root;

        helper(root.right);
    }
}

//Approach 2
class Solution {
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root, null, null);
        return flag;
    }

    private void helper(TreeNode root, Integer min, Integer max) {
        //base case
        if (root == null)
            return;

        helper(root.left, min, root.val);

        helper(root.right, root.val, max);

        if (min != null && root.val <= min) {
            flag = false;
        }

        if (max != null && root.val >= max) {
            flag = false;
        }
    }
}

/**
 * Can be traversed using Inorder/Preorder/Postorder traversal;
 * Validates a BST using recursion with min/max constraints.
 * Each node must be within its valid range: (min < node.val < max).
 * Updates bounds as recursion progresses to ensure correctness.
 * TC: O(n), SC: O(h) - where h is the height of the tree (recursive depth).
 */

