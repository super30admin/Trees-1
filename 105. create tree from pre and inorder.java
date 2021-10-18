// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//

// Your code here along with comments explaining your approach
//frst element is root in preorder..find that element in inorder..note the inde..(no dulicate array considered here)
//everything to left is left treee and to right is right tree..ogic is written in code
/**/**
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
        if(preorder.length==0){
            return null;
        }
        
        TreeNode root= new TreeNode(preorder[0]);
        int index=-1;
        
        //finding root in inorder
        
        for (int i=0; i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                index=i;
                break;
            }
        }
        
        //new pre and inorders for recursion
        
        int[] preLeft=Arrays.copyOfRange(preorder, 1, index + 1);
        int[] preRight=Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        int[] inLeft=Arrays.copyOfRange(inorder, 0, index);
        int[] inRight=Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left=buildTree(preLeft, inLeft);
        root.right=buildTree(preRight, inRight);
        
        return root;
    }
}