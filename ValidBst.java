// Time Complexity : O(n)
// Space Complexity : O(levels)
// Did this code successfully run on Leetcode : YES
// Three line explanation of solution in plain english

class ValidBst {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        isValid = true;
        Inorder(root);
        return isValid;
    }

    private void Inorder(TreeNode root) {
        if(root == null) return;
        Inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            isValid = false;
        }

        prev = root;
        if(isValid)
            Inorder(root.right);
    }
}