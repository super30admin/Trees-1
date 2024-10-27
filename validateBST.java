// Time Complexity : O(n)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class validateBST {
    class Solution {
        TreeNode prev = null;
        boolean flag = true;

        private void helper(TreeNode root) {
            if (root == null)
                return;

            if (flag)
                helper(root.left);

            if (prev != null && prev.val >= root.val) {
                flag = false;
            }
            prev = root;

            // conditonal recursion
            if (flag)
                helper(root.right);
        }

        public boolean isValidBST(TreeNode root) {
            helper(root);
            return flag;
        }
    }
}