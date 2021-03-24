//TC: O(n) -> elements of the array/node
//SC: O(n) -> Construction of tree - tree that we are storing - 
//Leetcode: yes!
//Problem: Python version....not being able to understand.
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
        
        // Sanitary Checks
        if(preorder==null || preorder.length == 0){
            return null;
        }
        
        // Inititalize the root 
        TreeNode root = new TreeNode(preorder[0]);
        
        // Find the root in inorder traversal to seperate right and left subtree
        int index = -1; //assuming it doesn't exist
        for (int i=0 ; i<inorder.length ; i++){
            if(inorder[i]==root.val){
                index = i;
                break;
            }
        }
        
        //Preorder extraction
        int[] preLeft = Arrays.copyOfRange(preorder, 1 , index + 1);
        int[] preRight = Arrays.copyOfRange(preorder, index + 1 , preorder.length);
        
        //Inorder
        int[] inLeft = Arrays.copyOfRange(inorder, 0 , index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1 , inorder.length);
        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);
        return root;
    }
    
}
