/**
 * TC - O(n) where n is total number of nodes
 * SC - O(h) where h is height of the tree
 */
public class ValidateBst {
     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.val <= min) || ( max != null && root.val >= max)) {
            return false;
        }

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
