// Time Complexity :O(n) n-number of nodes
// Space Complexity :O(h) h- maximum height of the tree 
// Did this code successfully run on Leetcode :yes 
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
    int index;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++)
        {
         map.put(inorder[i],i);   
        }
    return helper(inorder,preorder,0,inorder.length-1);
        
    }
    public TreeNode helper(int[] inorder,int[] preorder,int start,int end)
    {
        if(start>end || index>=inorder.length) return null;
        TreeNode root=new TreeNode(preorder[index]);
        int inInd=map.get(root.val);
        index++;
        root.left=helper(inorder,preorder,start,inInd-1);
        root.right=helper(inorder,preorder,inInd+1,end);
        
        return root;
        
    }
}