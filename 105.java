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

/** Algorithm :
Inorder : left root right
Preorder : root left right

preorder will give first element as root of tree
use inorder to locate the root element. left part is left subtree and right part is right subtree

TC : O(n) 
SC : O(n)
**/

//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder == null || preorder.length == 0) return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                index = i;
                break;  
            }
              
        }
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        //Inorder Left and Right
        int inLeft[] = Arrays.copyOfRange(inorder, 0, index);
        int inRight[] = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
        
    }
}