// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // base case
        if ( preorder == null || preorder.length == 0 || inorder.length == 0) return null;

        return helper(preorder, inorder);
    }

    private TreeNode helper(int[] preorder, int[] inorder) {

        // base
        if (preorder.length == 0 && inorder.length == 0) return null;

        // find the root index
        int rootIdx=-1;
        int rootValue = preorder[0];

        // initialize tree node root
        TreeNode root = new TreeNode(rootValue);

        for (int i=0; i< inorder.length; i++) {
            if(rootValue == inorder[i]) {
                rootIdx = i;
                break;
            }
        }

        // Breaking the arrays
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);

        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIdx + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIdx+1, preorder.length);

        // Recursion
        TreeNode left = helper(preorderLeft, inorderLeft);
        TreeNode right = helper(preorderRight, inorderRight);

        return root;
    }
}
