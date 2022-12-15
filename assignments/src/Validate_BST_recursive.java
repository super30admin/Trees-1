public class Validate_BST_recursive {

// Approach: Recursive, Time: O(n), Space: O(n)

    boolean flag = true;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {

        inOrder(root);
        return flag;
    }

    void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);

        if (prev != null && prev.val >= root.val) flag = false;
        prev = root;

        inOrder(root.right);
    }
}