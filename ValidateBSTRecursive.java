
class ValidateBSTRecursive {

    TreeNode prev = null;

    public boolean validateBSTRecursive(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        // LNR
        boolean leftResult = inorder(root.left);
        if (leftResult == false) {
            return false;
        }
        if (prev.val >= root.val && prev != null) {
            return false;
        }
        prev = root;
        System.out.println(root.val);

        return inorder(root.right);
    }

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
}