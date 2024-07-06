// Time Complexity : O(n^2) => As we are copying n elements in an array which results in O(n) but this is done for n elements
// Space Complexity : O(n^2) => Creating array of length n and is repeated for n elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: First calculated the root index value from inorder, the started creating 4 arrays: inorderLeft, inorderRight, preorderLeft & preorderRight by copying from existing arrays and calculated root's left & right child by recursively calling buildTree()
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0 || inorder == null ||
                inorder.length == 0) {
            return null;
        }

        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        // Find the root index in the inorder[]
        int rootIndex = -1;

        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {
                rootIndex = i;
                break;
            }
        }

        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        // Starts from 1 as we have already covered
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIndex + 1,
                preorder.length);

        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);

        return root;

    }

}