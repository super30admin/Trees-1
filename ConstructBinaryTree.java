import java.util.Arrays;

/**
 * LeetCode 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * Solution Approach: Recursion
 * 1. The first element in the preorder array is the root of the tree.
 * 2. Find the position of this root element in the inorder array to determine the left and right subtrees.
 * 3. Recursively repeat the process for the left and right subtrees using the corresponding segments of the preorder and inorder arrays.
 */
public class ConstructBinaryTree {

     public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode treeNode = new TreeNode();
        buildTree1(treeNode, preorder, inorder);
        return treeNode;
    }

    private void buildTree1(TreeNode treeNode, int[] preorder, int[] inorder) {
        if (preorder.length > 0) {
            int localRoot = preorder[0];
            treeNode.val = localRoot;
            int localRootPosInInorder = findPos(localRoot, inorder);
            int[] leftInOrder = Arrays.copyOfRange(inorder, 0, localRootPosInInorder);
            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftInOrder.length);
            if (leftPreorder.length > 0) {
                buildTree1(getLeft(treeNode), leftPreorder, leftInOrder);
            }
            int[] rightInOrder = Arrays.copyOfRange(inorder, localRootPosInInorder + 1, inorder.length);
            int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftInOrder.length, 1 + leftInOrder.length + rightInOrder.length);
            if (rightPreorder.length > 0) {
                buildTree1(getRight(treeNode), rightPreorder, rightInOrder);
            }
        }
    }

    private int findPos(int item, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (item == array[i]) return i;
        }
        return -1;
    }

    private TreeNode getLeft(TreeNode root) {
        TreeNode left = new TreeNode();
        root.left = left;
        return left;
    }

    private TreeNode getRight(TreeNode root) {
        TreeNode right = new TreeNode();
        root.right = right;
        return right;
    }

    static class TreeNode {
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
    
}