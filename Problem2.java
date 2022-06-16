// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//105. Construct Binary Tree from Preorder and Inorder Traversal
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Problem2 {
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inStrt = 0;
        int inEnd = inorder.length - 1;
        return build(inorder, preorder, inStrt, inEnd);
    }

    private TreeNode build(int[] inorder, int[] preorder, int inStrt, int inEnd) {

        if (inStrt > inEnd)
            return null;

        TreeNode tNode = new TreeNode(preorder[preIndex++]);// starting from the root and creating its left node by
                                                            // searching for the range from its inorder traversal

        if (inStrt == inEnd)
            return tNode;

        int inIndex = search(inorder, inStrt, inEnd, tNode.val);

        tNode.left = build(inorder, preorder, inStrt, inIndex - 1);
        tNode.right = build(inorder, preorder, inIndex + 1, inEnd);

        return tNode;
    }

    /* UTILITY FUNCTION */
    private int search(int arr[], int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

}
