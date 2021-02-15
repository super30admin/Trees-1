// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, preorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        // overlapped the sides
        if (preStart >= preorder.length || inStart > inEnd)
            return null;

        // the root
        TreeNode node = new TreeNode(preorder[preStart]);

        int index = 0;

        // finding the partition point
        for (index = inStart; index <= inEnd; index++)
            if (inorder[index] == node.val)
                break;

        // making left and right sides of tree
        node.left = helper(preStart + 1, inStart, index - 1, preorder, inorder);
        node.right = helper(preStart + 1 + index - inStart, index + 1, inEnd, preorder, inorder);

        return node;
    }
}