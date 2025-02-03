
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    HashMap<Integer, Integer> map;
    int preIdx = 0; // preorder index
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // TC = O(N)
        // SC = O(N) + O(H) = O(N)
        // null
        if(preorder.length == 0 || inorder.length == 0) return null;
        map = new HashMap<>();
        // mapping index of inorder
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(preorder, 0, preorder.length - 1);
    }
// use preorder to find root, then start & end for the left & right subtree. Then use recursion
    private TreeNode helper(int[] preorder, int start, int end) {
        // base
        if(start > end) return null;
        // logic
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);
        return root;
    }
}