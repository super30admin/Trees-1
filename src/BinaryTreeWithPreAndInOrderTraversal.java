import java.util.Arrays;
import java.util.HashMap;

/*
Problem: Construct Binary Tree from Preorder and Inorder Traversal

Approach 1 (Brute force using array slicing):
- Root is always preorder[0].
- Find root index in inorder (O(n)).
- Split inorder into left/right; split preorder accordingly; recurse.
Time: O(n^2) in worst case (skewed tree) because each level does O(n) search + array copies.
Space: O(n^2) in worst case due to creating many subarrays (copyOfRange), plus recursion stack.

Approach 2 (Optimal using HashMap + pointer idx):
- Build a map: value -> inorder index in O(n).
- Maintain a global pointer idx over preorder to pick the next root in O(1).
- Recurse using inorder boundaries [start..end] instead of slicing arrays.
Time: O(n) because each node is processed once and lookups are O(1).
Space: O(n) for the map + recursion stack (O(h), worst O(n)).
*/
public class BinaryTreeWithPreAndInOrderTraversal {

    // Basic TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Approach 1: Brute force with slicing
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return treeHelper(preorder, inorder);
    }

    private TreeNode treeHelper(int[] preorder, int[] inorder) {
        // Base case: no nodes to build
        if (preorder.length == 0 || inorder.length == 0) return null;

        // Root is the first element of preorder
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        // Find root position in inorder (to split left/right subtrees)
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // Split inorder into left and right arrays
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inorderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        // Preorder splits: after root, next inorderLeft.length items belong to left subtree
        // copyOfRange end index is exclusive, so use 1 + inorderLeft.length
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, 1 + inorderLeft.length);
        int[] preorderRight = Arrays.copyOfRange(preorder, 1 + inorderLeft.length, preorder.length);

        root.left = treeHelper(preorderLeft, inorderLeft);
        root.right = treeHelper(preorderRight, inorderRight);

        return root;
    }

    // Approach 2: Optimal (HashMap + preorder index pointer)
    private int idx; // moving pointer for preorder

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        // Reset idx for each run
        idx = 0;

        // Map inorder value -> inorder index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return treeHelper2(preorder, map, 0, inorder.length - 1);
    }

    private TreeNode treeHelper2(int[] preorder, HashMap<Integer, Integer> map, int start, int end) {
        // Base case: no inorder range to build
        if (start > end) return null;

        // Pick current root from preorder using idx
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;

        // Find root position in inorder using the map
        int rootIndex = map.get(rootVal);

        // Build left subtree from inorder[start .. rootIndex-1]
        root.left = treeHelper2(preorder, map, start, rootIndex - 1);

        // Build right subtree from inorder[rootIndex+1 .. end]
        root.right = treeHelper2(preorder, map, rootIndex + 1, end);

        return root;
    }

    // ---------- Helpers for testing ----------
    private static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    private static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // Simple test cases (prints traversals to confirm correctness)
    public static void main(String[] args) {
        BinaryTreeWithPreAndInOrderTraversal builder = new BinaryTreeWithPreAndInOrderTraversal();

        // Test 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1  = {9, 3, 15, 20, 7};

        TreeNode t1a = builder.buildTree(preorder1, inorder1);
        TreeNode t1b = builder.buildTree2(preorder1, inorder1);

        // Expect inorder: 9 3 15 20 7
        // Expect preorder: 3 9 20 15 7
        printInorder(t1a); System.out.println();
        printPreorder(t1a); System.out.println();

        printInorder(t1b); System.out.println();
        printPreorder(t1b); System.out.println();

        // Test 2 (single node)
        int[] preorder2 = {1};
        int[] inorder2  = {1};

        TreeNode t2 = builder.buildTree2(preorder2, inorder2);
        printInorder(t2); System.out.println();
        printPreorder(t2); System.out.println();

        // Test 3 (skewed tree)
        int[] preorder3 = {1, 2, 3, 4};
        int[] inorder3  = {1, 2, 3, 4};

        TreeNode t3 = builder.buildTree2(preorder3, inorder3);
        printInorder(t3); System.out.println();
        printPreorder(t3); System.out.println();
    }
}
