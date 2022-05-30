// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//we know that first element in preorder contains root, and in inorder root is after left subtree and before rightSubtree,
//using this logic we'll prepare inorder and preorder of leftsubtree and rightSubtee and will make it
//root's left and right resp at the end, we'll return root

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // edge case
        if (preorder.length == 0)
            return null;

        // logic
        int par = preorder[0];
        int indexOfParInInor = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == par) {
                indexOfParInInor = i;
                break;
            }
        }
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, indexOfParInInor);
        int[] inorderRight = Arrays.copyOfRange(inorder, indexOfParInInor + 1, inorder.length);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, inorderLeft.length + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, inorderLeft.length + 1, preorder.length);
        TreeNode root = new TreeNode(par);
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        return root;
    }
}