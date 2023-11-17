// Time Complexity : O(n), n -> no of nodes
// Space Complexity : O(h), h -> height of the tree
/* Definition for a binary tree node.*/
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

class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        boolean result = isValidateBST(root);
        System.out.println(result);
    }

    private static boolean isValidateBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return checkBST(root, min, max);
    }

    private static boolean checkBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        return ((root.val > min && root.val < max) && checkBST(root.left, min, root.val)
                && checkBST(root.right, root.val, max));
    }
}