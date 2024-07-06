// Time Complexity : O(n) => As we are iterating over the n nodes
// Space Complexity : O(h) => Even though we don't use explicit stack we are
// using recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach: This is the recursive way where we use a prev pointer along with
 * the recurse() method of type boolean. Value of prev pointer is compared with the
 * value of the next node, if it is greater then it indicates it is not a valid
 * BST
 */
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        prev = null;

        return recurse(root);
    }

    private boolean recurse(TreeNode root) {

        if (root == null) {
            return true;
        }

        boolean case1 = recurse(root.left);

        if (prev != null && prev.val >= root.val) {
            return false;
        }

        prev = root;

        boolean case2 = recurse(root.right);

        return case1 && case2;
    }
}