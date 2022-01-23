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
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    int preorderIndex;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildSubTree(preorder, 0, inorder.length-1);
    }

    public TreeNode buildSubTree(int[] preorder, int left, int right) {
        if(left > right) {
            return null;
        }

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = buildSubTree(preorder, left, map.get(rootValue)-1);
        root.right = buildSubTree(preorder, map.get(rootValue)+1, right);
        return root;
    }
}