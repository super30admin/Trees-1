// TC O(N)
// SC O(N)
public class ValidateTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode prev;

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null)
            return true;
        boolean left = inorder(root.left);
        if (prev != null) {
            boolean isValid = prev.val < root.val;
            if (!isValid) {
                return false;
            }
        }
        prev = root;
        boolean right = inorder(root.right);
        return left && right;
    }
}
