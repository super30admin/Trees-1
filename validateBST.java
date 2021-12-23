// Time Complexity : O(n)
// Space Complexity : O(h), where h is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
// Solution 1: In-order traversal guarentees ascending order traversal, and hence we use it here since we will be storing prev
// element for checking the value, if value of prev is greater than or equal to the current node, we return a false
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        //base case
        if (root == null) {
            return true;
        }
        // Logic
        // Inorder traversal with prev variable being updated updated with root after checking prev
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && prev.val>=root.val) {
            return false;
        }
        prev = root;
        return inorder(root.right);
    }
}

// Solution 2: Here we pass min and max Integer to the helper method and then check if the root.val lies within the min and max value, if not we return false.
// And while calling the function recursively with left and right, we update the max and min values rerspectively
// Time Complecity = O(n)
// Space Complecity = O(h)
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        //base case
        if (root == null) {
            return true;
        }
        // Logic
        if ((min != null && min >= root.val) || (max != null && max <= root.val)) {
            return false;
        }

        if (!helper(root.left, min, root.val)) {
            return false;
        }
        return helper(root.right, root.val, max);
    }
}