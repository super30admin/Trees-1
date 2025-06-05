// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
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
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int inStart, int inEnd) {
        // base case
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRootIdx = inorderMap.get(rootVal);
        int leftTreeSize = inRootIdx - inStart;

        root.left = helper(preorder, preStart + 1, inStart, inRootIdx - 1);
        root.right = helper(preorder, preStart + 1 + leftTreeSize, inRootIdx + 1, inEnd);

        return root;
    }
}
