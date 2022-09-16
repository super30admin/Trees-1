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
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        
        return helper(preorder, 0,inorder.length-1);
        
        
    }
    private TreeNode helper(int[] preorder, int start, int end)
    {
        //base case   
        if(start>end) return null;
        
        
        int rootVal = preorder[idx];
        int rootindex = map.get(rootVal);
        idx++;
        TreeNode root = new TreeNode(rootVal);
        //logic
        root.left = helper(preorder, start, rootindex-1);
        root.right = helper(preorder, rootindex+1, end);
        return root;
    }
}