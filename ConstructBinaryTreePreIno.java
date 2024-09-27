// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :no

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
    HashMap<Integer , Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)return null;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length ; i++){
            map.put(inorder[i],i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
        
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        
        if(start>end ||index>=preorder.length)return null;
        
        int inIdx = map.get(preorder[index]);
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = helper(preorder, inorder , start ,inIdx - 1);
        root.right = helper(preorder, inorder , inIdx + 1 ,end);
        return root;
        
    }
}