// Time Complexity : O(n) where  n is number of nodes
// Space Complexity : O(h) where h is height of the tree. (Considering the recursion stack)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No. 

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
    
    HashMap<Integer,Integer> map = new HashMap<>();
    int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        
        return helper(preorder,0,inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end)
    {
      
        if(start>end) return null;
        
        int rootVal = preorder[preIndex];
        preIndex++;
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        root.left = helper(preorder,start,index-1);
        root.right = helper(preorder,index+1,end);
        return root;
    }
}    