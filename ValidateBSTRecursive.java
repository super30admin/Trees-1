// TC: O(n)
// SC: O(h)
class Solution {
    private TreeNode prev = null;
    boolean result = true;
    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            result = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return result;
    }
}