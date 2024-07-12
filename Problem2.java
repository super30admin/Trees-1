// Problem2.java

public class Problem2 {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
            // Base case: if any of the indices are out of bounds, return null
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }

            // Create a new TreeNode with the value at the current index in the preorder array as the root of the current subtree
            TreeNode root = new TreeNode(preorder[preStart]);

            // Find the index of the root in the inorder array
            int inorderRootIndex = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == root.val) {
                    inorderRootIndex = i;
                    break;
                }
            }

            // Calculate the size of the left subtree
            int leftSubtreeSize = inorderRootIndex - inStart;

            // Recursively construct the left and right subtrees, and set them as the left and right children of the current root node
            root.left = buildTreeHelper(preorder, inorder, preStart + 1, preStart + leftSubtreeSize, inStart, inorderRootIndex - 1);
            root.right = buildTreeHelper(preorder, inorder, preStart + leftSubtreeSize + 1, preEnd, inorderRootIndex + 1, inEnd);

            // Return the current root node
            return root;
        }
    }

    private static void printTree(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode tree1 = solution.buildTree(preorder1, inorder1);
        System.out.print("Tree 1: ");
        printTree(tree1);  // Expected output: 3 9 20 15 7
        System.out.println();

        // Test case 2
        int[] preorder2 = {1, 2, 3};
        int[] inorder2 = {2, 1, 3};
        TreeNode tree2 = solution.buildTree(preorder2, inorder2);
        System.out.print("Tree 2: ");
        printTree(tree2);  // Expected output: 1 2 3
        System.out.println();
    }
}
