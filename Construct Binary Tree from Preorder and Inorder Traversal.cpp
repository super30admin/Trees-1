// TC = O(N)
// SC = O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
    int index; // preorder
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // TC = O(N)
        // SC = O(N)
        // null
        if(preorder.length == 0) return null;
        map = new HashMap<>();
        // mapping index of inorder
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(preorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int start, int end) {
        // base
        if(start > end) return null;
        // logic
        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        // important to build left tree first then right
        root.left = helper(preorder, start, rootIndex - 1);
        root.right = helper(preorder, rootIndex + 1, end);
        return root;
    }
}