/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 // Time complexity - O(n^2)
 // Space complexity - O(n)
 // Did you face any issue - No
 // Solved on leetcode - Yes

 // Since, preorder always have root at 1st, we are split the left and right elements and agian calling the tree. So to do this we are identifying the index of 1st element of preorder in inorder. The elements count which are towards the left side will be in left to the tree and elements count which are in right side will be to the right of the tree.
public class Solution {
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find root in inorder array (linear scan)
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        root.left = helper(preorder, inorder, inStart, index - 1);
        root.right = helper(preorder, inorder, index + 1, inEnd);

        return root;
    }
}
