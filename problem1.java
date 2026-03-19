    /**
    Time Complexity : O(N)
    Explanation:
    We perform an inorder traversal of the tree and visit each node once.

    Space Complexity : O(H)
    Explanation:
    Recursion stack depends on tree height.
    Worst case (skewed tree) → O(N), balanced tree → O(log N).

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially tried checking only parent-child relationships,
    which fails for deeper subtree violations.
    Fixed it using inorder traversal because inorder traversal
    of a valid BST must produce strictly increasing values.
    */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    boolean flag = true;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {

        helper(root);
        return flag;
    }

    void helper(TreeNode root) {

        if (root == null) {
            return;
        }

        // Traverse left subtree
        helper(root.left);

        // Check BST condition
        if (prev != null && prev.val >= root.val) {
            flag = false;
        }

        // Update previous node
        prev = root;

        // Traverse right subtree
        helper(root.right);
    }
}