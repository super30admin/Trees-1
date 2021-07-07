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

// Time : O(N) Space: O(N) 
// Inorder is left root right poreorder is root left right .... so first element on preorder will be root 
// then will find that root element in inorder to get index of it so that value from that point on left will be left subtree and value on right will right subtree... repeat this process.
class Solution {
    
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        TreeNode n =generateTree(preorder,inorder, 0 , inorder.length-1);
        
        return n;
        
    }
    
    public TreeNode generateTree(int preorder[], int inorder[], int start, int end) 
    {
       if(start > end){
           return null;
       }
        
        TreeNode root = new TreeNode(preorder[index++]);
        if(start ==end){
            return root;
        }
        
        int indexfromi = indexfromIn(root.val , inorder, start, end);
        
         root.left = generateTree(preorder,inorder, start, indexfromi-1);
        root.right = generateTree(preorder , inorder , indexfromi +1 , end);
        
        return root;
       
    }
    public int indexfromIn(int preorder , int [] inorder , int start , int end){
        
        for(int i =start;  i <= end ; i++){
            if(preorder == inorder[i]){
                return i;
            }
        }
        
        return -1;
        
    }
    
    
    
}