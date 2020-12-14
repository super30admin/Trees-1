// Time Complexity :O(N) where n is the number of nodes 
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
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
    
        int index= 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0)
            return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < inorder.length ; i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,map,0,inorder.length-1);
    }
    public TreeNode helper(int[] preorder, HashMap<Integer, Integer> map, int start, int end){
        if(start>end)
            return null;
        int value = preorder[index];
        TreeNode root = new TreeNode(value);
        int rootIndex = map.get(value);
        index++;
        root.left = helper(preorder,map,start,rootIndex-1);
        root.right = helper(preorder,map,rootIndex+1,end);
        return root;
    }
}