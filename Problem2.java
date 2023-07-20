class Solution {
    boolean flag;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        return this.flag;
    }

    private void recur(TreeNode root) {
        // base
        if (root == null)
            return;
        if (flag)
            recur(root.left);
        // logic
        if ((prev != null) && (prev.val >= root.val)) {
            // System.out.println(prev.val);
            // System.out.println(root.val);
            flag = false;
        }
        prev = root;
        if (flag)
            recur(root.right);

    }
}