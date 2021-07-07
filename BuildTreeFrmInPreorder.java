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
    /*
1.Create preorder and inorder array separately for every left and right calls using the index of preorder in inorder
*/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(inorder.length == 0 || preorder.length == 0) return null;
        
        int index = -1;
        
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 0; i < inorder.length; i++){
           if(inorder[i]==preorder[0]){
               index = i;
               break;
           }
        }
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
    }
}





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
    
        // Time Complexity : O(No. of treenodes )
// Space Complexity : O(No. of treenodes)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1.For getting the index of root in inorder, we use HashMap.
2.We use helper function, with the range of inorder we need for that subtree(left or right)
2.Based on the map value, we rewrite the left and right function.
*/
    
    int preIndex = 0;
    HashMap<Integer, Integer> hm;
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(inorder.length == 0 || preorder.length == 0) return null;
        
        hm = new HashMap<Integer, Integer>();
        ll 
        for(int i = 0; i < inorder.length; i++){
           hm.put(inorder[i],i);
        }
        
        return helper(preorder, inorder, 0, preorder.length-1);
    
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //base
        if(start>end || preIndex>=preorder.length) return null;
        
        //logic
        TreeNode root = new TreeNode(preorder[preIndex]);
        int inIndex = hm.get(preorder[preIndex]);
        preIndex++;
        root.left = helper(preorder, inorder, start, inIndex-1);
        root.right = helper(preorder, inorder, inIndex+1, end);
        return root;
    }
}