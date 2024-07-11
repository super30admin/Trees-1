// Time Complexity : O(n) each element is treaversed exactly once in preorder and inorder
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class TreeNode {
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

public class BinaryTree {
    private int preorderIndex = 0; 
    private int inorderIndex = 0;  

    // Public method to build the tree given preorder and inorder traversals
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    // Helper method to recursively build the tree
    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        // Base case: if we have traversed all elements in preorder array
        if (preorderIndex >= preorder.length) {
            return null;
        }
        // Base case: if the current value in inorder array matches the stop value
        if (inorder[inorderIndex] == stop) {
            ++inorderIndex;
            return null;
        }

        // Create the current root node with the current value in preorder array
        TreeNode node = new TreeNode(preorder[preorderIndex++]);

        // Recursively build the left subtree
        node.left = build(preorder, inorder, node.val);

        // Recursively build the right subtree
        node.right = build(preorder, inorder, stop);

        return node;
    }

    // Helper method to print the tree in inorder traversal (for verification)
    private void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree solution = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println("Tree built successfully!! Inorder : ");
        solution.printInorder(root);
    }
}