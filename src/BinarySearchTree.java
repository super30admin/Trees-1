/*
Valid BST checks (two ways)

1) Inorder traversal:
   - Inorder of a BST is strictly increasing.
   - Track previous node; if prev.val >= curr.val -> invalid.

2) Range recursion:
   - Each node must be within (min, max).
   - Left subtree: (min, node.val), Right subtree: (node.val, max).
*/

public class BinarySearchTree {

    // Basic TreeNode
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // ---------- Approach 1: Inorder ----------
    private boolean inorderValid;
    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        inorderValid = true;   // assume valid
        prev = null;           // reset for each run
        inorderHelper(root);
        return inorderValid;
    }

    private void inorderHelper(TreeNode node) {
        if (node == null || !inorderValid) return; // stop early if invalid

        inorderHelper(node.left);

        // inorder must be strictly increasing
        if (prev != null && prev.val >= node.val) {
            inorderValid = false;
            return;
        }
        prev = node;

        inorderHelper(node.right);
    }

    // ---------- Approach 2: Range recursion ----------
    public boolean isValidBSTUsingRange(TreeNode root) {
        return rangeHelper(root, null, null);
    }

    private boolean rangeHelper(TreeNode node, Long min, Long max) {
        if (node == null) return true;

        long v = node.val;
        if (min != null && v <= min) return false;
        if (max != null && v >= max) return false;

        return rangeHelper(node.left, min, v) && rangeHelper(node.right, v, max);
    }

    // Helper to create node quickly
    private static TreeNode n(int val) { return new TreeNode(val); }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Test 1: Empty tree -> true
        System.out.println(bst.isValidBST(null));
        System.out.println(bst.isValidBSTUsingRange(null));

        // Test 2: Single node -> true
        TreeNode t2 = n(5);
        System.out.println(bst.isValidBST(t2));
        System.out.println(bst.isValidBSTUsingRange(t2));

        // Test 3: Valid BST
        //        5
        //      /   \
        //     3     7
        //    / \   / \
        //   2  4  6  8
        TreeNode t3 = n(5);
        t3.left = n(3); t3.right = n(7);
        t3.left.left = n(2); t3.left.right = n(4);
        t3.right.left = n(6); t3.right.right = n(8);
        System.out.println(bst.isValidBST(t3));
        System.out.println(bst.isValidBSTUsingRange(t3));

        // Test 4: Invalid BST (classic)
        //        5
        //      /   \
        //     1     4
        //          / \
        //         3   6
        TreeNode t4 = n(5);
        t4.left = n(1);
        t4.right = n(4);
        t4.right.left = n(3);
        t4.right.right = n(6);
        System.out.println(bst.isValidBST(t4));
        System.out.println(bst.isValidBSTUsingRange(t4));

        // Test 5: Invalid due to duplicate (strict BST)
        //    2
        //   / \
        //  1   2
        TreeNode t5 = n(2);
        t5.left = n(1);
        t5.right = n(2);
        System.out.println(bst.isValidBST(t5));
        System.out.println(bst.isValidBSTUsingRange(t5));

        // Test 6: Invalid deep in subtree
        //        10
        //       /  \
        //      5    15
        //          /  \
        //         6   20
        TreeNode t6 = n(10);
        t6.left = n(5);
        t6.right = n(15);
        t6.right.left = n(6);
        t6.right.right = n(20);
        System.out.println(bst.isValidBST(t6));
        System.out.println(bst.isValidBSTUsingRange(t6));
    }
}
