class IsValidBSTSolution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        boolean left = isValid(root.left, min, root.val);
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        boolean right = isValid(root.right, root.val, max);
        return left && right;
    }
}