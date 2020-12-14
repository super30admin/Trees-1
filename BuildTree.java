// Time Complexity : O(N * N) 
// Space Complexity : O(N * N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(inorder == null || inorder.length == 0) {
            return null;
        }
        int rootval = preorder[0];
        TreeNode root = new TreeNode(rootval);
        int idx = -1;
        
        for(int i = 0; i < inorder.length; i++) {
            if(rootval == inorder[i]) {
                idx = i;
            }
        }
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, idx + 1);
        int[] preRight = Arrays.copyOfRange(preorder, idx + 1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
        int[] inRight = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
        
    }
}