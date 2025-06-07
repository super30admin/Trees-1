
/**
 *Time Complexity: O(n)
 *Space Complexity: O(h)
 *    - Due to recursion stack where h = height of tree.
 */

class Node {
    int val;
    TreeNode left, right;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        if (root.val <= min || root.val >= max)
            return false;

        boolean left = isBST(root.left, min, root.val);
        boolean right = isBST(root.right, root.val, max);
        return left && right;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree sol = new ValidateBinarySearchTree();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(8);

        System.out.println("Is valid BST: " + sol.isValidBST(root));
    }
}
