// Time Complexity : O(n) where n is the number of the elements in the array
// Space Complexity : O(n) where n is the elements in the hashmap
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
    HashMap<Integer,Integer> map;
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0 || inorder.length == 0) return null;
        
        map = new HashMap<>();
        int start = 0;
        int end  = inorder.length;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return helper(preorder,inorder,start,end);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //base case
        if(start > end || index>= preorder.length) return null;
        
        //logic
        int inIdx = map.get(preorder[index]);
        TreeNode root = new TreeNode(preorder[index]);
        index ++;
        root.left = helper(preorder,inorder,start,inIdx-1);
        root.right = helper(preorder,inorder,inIdx+1,end);
        return root;
        
    }
}