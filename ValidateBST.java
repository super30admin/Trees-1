// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ValidateBST {

        // We need to check if all elements in left sub tree are lower than root and
        // all elements in right sub tree are greater than root for each subtree

        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        // helper function for recursion
        public boolean helper(TreeNode node, Integer lower, Integer upper) {
            // base case
            if (node == null) {
                return true;
            }

            int val = node.val;

            // termination cases
            //1. if root is lower than lower elements in subtree
            if (lower != null && val <= lower) {
                return false;
            }
            //2. if root is greater than upper elements in subtree
            if (upper != null && val >= upper) {
                return false;
            }

            // recursion

            //3. checking in left subtree for upper value as val and lower as lower
            if (!helper(node.left, lower, val)) {
                return false;
            }

            //4. checking in right subtree for upper value as upper and lower as val
            if (!helper(node.right, val, upper)) {
                return false;
            }

            return true;
        }
}
