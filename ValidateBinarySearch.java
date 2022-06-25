// Time : O(n)
// Space : O(1)
class Solution {
    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;

    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root;
        if (flag)
            inorder(root.right);

    }
}