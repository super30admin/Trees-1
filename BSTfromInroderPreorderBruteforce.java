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
//tc- o(n) search for every recursive call making n calls and making 4 arrays - o(n2)
//sc -o(n2) every call making 4 arrays of size n/2
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int rootval = preorder[0];
        TreeNode root = new TreeNode(rootval);
        int indx=-1;
        //o(n) search
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i] == rootval)
            {
                indx = i;
                break;
            }   
        }
        int[] inLeft = Arrays.copyOfRange(inorder, 0, indx);//goes upto indx-1, last value not counted
        int[] preLeft = Arrays.copyOfRange(preorder, 1,inLeft.length+1);//goes upto inleft.length  // or //upto indx+1
        int[] inRight = Arrays.copyOfRange(inorder, indx+1, inorder.length);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, preorder.length);//or from idx+1
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        
            
        return root; 
        
        
    }
}