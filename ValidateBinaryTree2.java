public class ValidateBinaryTree2 {
    TreeNode prev = null;
    boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        isValidBSTHelper(root);
        return isValid;
    }

    private void isValidBSTHelper(TreeNode root) { // Traverse in order
        if (root == null)
            return;

        if(isValid == false) return; // Stop further processing if already invalid
        isValidBST(root.left);

        if (prev != null && root.val < prev.val) {
            isValid = false;
        }

        prev = root;
        isValidBST(root.right);
        

    }

    class TreeNode {
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
