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
        // Sanity check
        if(preorder == null || preorder.length == 0){
            return null;
        }   
        // create TreeNode with preorder[0], as in preorder root is at first place
        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        // finding root value index in inorder array
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        // Left subtree in preorder array, we can find using index
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
        // Right subtree
        int[] preRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        // Left subtree in inorder array
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        // Right subtree in inorder array
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        // finding root left and right parts
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
        
    }
}