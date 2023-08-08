// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class ConstructBinaryTreeFromPreOrderAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
        if (preIndex >= preorder.length || inStart > inEnd) {
            return null;
        }

        // The first element in preorder array is the root of the current subtree
        TreeNode root = new TreeNode(preorder[preIndex]);

        // Find the index of the root in inorder array
        int rootIndexInInorder = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndexInInorder = i;
                break;
            }
        }

        // Recursively build left and right subtrees
        root.left = buildTreeHelper(preorder, inorder, preIndex + 1, inStart, rootIndexInInorder - 1);
        root.right = buildTreeHelper(preorder, inorder, preIndex + rootIndexInInorder - inStart + 1, rootIndexInInorder + 1, inEnd);

        return root;
    }
}