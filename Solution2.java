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
        
        if(preorder == null || preorder.length == 0) return null;
      
         
        TreeNode root = new TreeNode(preorder[0]); 
        // First elemen is the root node 
        int index = -1;
        
        
        for (int i=0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;  
           // index =. 0     
                break;
        }
    }
        //Preorder left and right side gives left and right subtree , we take the range of those values and store in preLeft and preRight
        int[] preleft = Arrays.copyOfRange(preorder, 1, index+1); 
        int[] preRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        
        int[] inLeft = Arrays.copyOfRange(inorder,0,index);
        int[] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
            
        root.left = buildTree(preleft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
    }

}
