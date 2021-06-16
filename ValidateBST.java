class ValidateBST {
    //O(2^n) time and O(n) space
    public boolean isValidBST(TreeNode root) {

        boolean left = recurse(root.left);
        boolean right = recurse(root.right);

        return left && right;

    }

    private boolean recurse(TreeNode root) {

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left.val < root.val && root.right == null) {
            return true;
        }

        if (root.right.val > root.val && root.left == null) {
            return true;
        }

        if (root.right.val > root.val && root.left.val < root.val) {
            return true;
        }

        return false;
    }
}