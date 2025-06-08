TC: O(N)
SC: O(N)

// each node is bounded by 2 values low & high for ex: -infinity & +infinity
// for left side traversal to the root , low is always -infinity & high is always root.val
// for right side traversal to the root , low is always root.val & high is always +-infinity

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
class ValidateBST_LC98 {
    public boolean isValidBST(TreeNode root) {

        return validate(root, null, null);
    }

    private boolean validate(TreeNode root, Integer low, Integer high) {

        if (root == null) return true;
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
                return false;
        }

        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }
}