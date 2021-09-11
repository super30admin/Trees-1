// Time Complexity : O(n) where n is the length of the inorder or preorder array
// Space Complexity : O(n) where n is the length of the inorder or preorder array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

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
    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(preorder, 0 , inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int start, int stop){
        if(start > stop){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[index]);
        int inorderIndex = map.get(preorder[index]);
        index++;
        
        root.left = helper(preorder, start, inorderIndex-1);
        root.right =  helper(preorder, inorderIndex+1, stop);   
            
        return root;
    }
}