Time complexity : O(n)
Space Complexity : O(n)

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
        int index = -1;
        if(preorder.length == 0 || preorder == null) return null;
        TreeNode root = new TreeNode(preorder[0]);
        //searching for the root in inorder
        for(int i =0; i<inorder.length; i++){
            if(inorder[i] == root.val)
            {
                index = i;
                break;
            }
        }
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index +1);
        int[] preRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
    return root;
    }
    
    
}