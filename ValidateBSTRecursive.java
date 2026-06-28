
class ValidateBSTRecursive {
    boolean flag;
    TreeNode prev;

    public boolean validateBSTRecursive(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }
    private void helper(TreeNode root) {
        if (root==null) return;
        if (!flag) return;
        helper(root.left);
        if (prev != null && root.val <= prev.val){
            flag = false;
        }
        prev = root;
        helper(root.right);
    }
}