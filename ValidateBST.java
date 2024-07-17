/**
 * Time Complexity: O(N)
 * Space Complexity: O(H) - H represents Height of the Tree
 */

class Solution {
    TreeNode prev;
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (prev != null && prev.val >= root.val)
            flag = false;
        prev = root;

        if (flag) {
            inorder(root.right);
        }
    }
}
