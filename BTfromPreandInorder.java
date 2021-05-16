// Space complexity - O(n)
// Space complexity - O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

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
        
        if(preorder.length == 0){return null;}
        
        int idx = -1; //index of root in inorder traversal
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        
        for(int i = 0; i < inorder.length; i ++){
            
            if(inorder[i] == rootValue){
                
                idx = i;
                break;
            }
        }
        
       int[] preorderleft = Arrays.copyOfRange(preorder,1,idx+1);
       int[] preorderright = Arrays.copyOfRange(preorder,idx+1,preorder.length);
       int[] inorderLeft = Arrays.copyOfRange(inorder,0,idx);
       int[] inorderRight = Arrays.copyOfRange(inorder,idx+1,inorder.length);
            
        root.left = buildTree(preorderleft,inorderLeft);
        root.right = buildTree(preorderright,inorderRight);
        
        return root;
        
        
    }
}