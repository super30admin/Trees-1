import java.util.HashMap;
// Time Complexity :O(n) touched all nodes
// Space Complexity : O(h)+O(n) size of HashMap and maximum nodes in the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


class Solution {
    
    //Using Recursion
    //Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
   TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

     HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder==null||preorder.length==0||inorder==null) return null;
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return helper(preorder,0,preorder.length-1);
    
    }
    
    private TreeNode helper(int[] preorder, int start, int end) {
        
        //base case
        if(start>end)
            return null;
        
        //logic
        int rootVal=preorder[idx];
        idx++;
        int rootIndex=map.get(rootVal);
        TreeNode root= new TreeNode(rootVal);
        root.left=helper(preorder,start,rootIndex-1);
        root.right=helper(preorder, rootIndex+1,end);
        return root;
    }
}