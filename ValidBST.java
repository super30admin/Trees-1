/* The time complexity to find if the tree implementation is BST is O(n)*/
public class ValidBST {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        boolean isValid = isValidBST(root);
        System.out.println("Is the binary tree valid BST? " + isValid);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
