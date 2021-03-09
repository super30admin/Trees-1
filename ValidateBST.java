// we just need to follow the BST rules and check those rules as we tracerse through the tree. 
// if we come to a position where the rules break, we return false if not we return true

// Time Complexity : O(N), where N is the number of nodes in the tree
// Space Complexity : O(N)

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null)
            return true;
        if (min != null && node.val <= min.val || max != null && node.val >= max.val) {
            return false;
        }

        return isValidBST(node.left, min, node) && isValidBST(node.right, node, max);
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(2, left, right);

        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.isValidBST(root));
    }
}