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
class ValidateBST {
    boolean isValid = true;
    TreeNode prev = null;

    // TC: O(N) where N is number of nodes
    // SC: O(H) where H is max height of tree
    public boolean isValidBST(TreeNode root) {
        return rangeCheck(root, Long.MIN_VALUE, Long.MAX_VALUE);
        // inorderWithUnboundedRecursion(root);
        // inorderWithConditionalRecursion(root);
        // return isValid;
    }

    private void inorderWithUnboundedRecursion(TreeNode root) {
        if (root != null) {
            inorderWithUnboundedRecursion(root.left);
            if (prev != null && root.val <= prev.val) {
                isValid = false;
            }
            prev = root;
            inorderWithUnboundedRecursion(root.right);
        }
    }

    private void inorderWithConditionalRecursion(TreeNode root) {
        if (root != null) {
            inorderWithConditionalRecursion(root.left);
            if (prev != null && root.val <= prev.val) {
                isValid = false;
            }
            prev = root;
            if (isValid) {
                inorderWithConditionalRecursion(root.right);
            }
        }
    }

    private boolean rangeCheck(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return rangeCheck(root.left, min, root.val) && rangeCheck(root.right, root.val, max);
    }
}