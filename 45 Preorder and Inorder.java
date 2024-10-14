// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    HashMap<Integer, Integer>  map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.idx = 0;
        this.map = new HashMap<>();

        for(int i=0;i<inorder.length ; i++)
        {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] preorder, int start, int end)
    {
        if(start>end)
        {
            return null;
        }

        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map.get(rootVal);
        
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder,start, rootIdx-1);
        root.right = helper(preorder, rootIdx+1, end);


        return root;
    } 
}