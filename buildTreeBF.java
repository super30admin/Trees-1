// Time Complexity : O(n^2) [recursive stack + array used to copy left and right elements]
// Space Complexity : O(n^2) [recursive stack + array used to copy left and right elements]
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
        if(preorder == null || preorder.length == 0)
            return null;
        
        //find root in preorder
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        
        //search root in inorder
        int rootIdx = 0;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == rootVal)
                rootIdx = i;
        }
        
        //find inorder left, inorder right , preorder left, preorder right range
        //in arrays.copyOfRange, the last index is ingored, so we give +1 index in range
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIdx+1);
        int[] preRight = Arrays.copyOfRange(preorder, rootIdx+1 , preorder.length);
        
        
        //build left and right tree now
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
    }
}
