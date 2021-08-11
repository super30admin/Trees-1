class Solution {

    //O(n) space and time

    private TreeNode prev;
    public boolean result;

    public boolean isValidBST(TreeNode root) {

        result = true;
        recurse(root);
        return result;

    }

    private void recurse(TreeNode root) {

        if (root == null)return;

        recurse(root.left);

        if (prev != null && prev.val >= root.val) {
            result = false;
            return;
        }
        prev = root;
        recurse(root.right);

    }
}