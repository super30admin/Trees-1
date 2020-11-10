// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes
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
    int idx=0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {


        if(preorder.length==0||inorder.length==0)
            return null;

        map=new HashMap<>();

        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }

        return helper(preorder,inorder,0,inorder.length-1);

    }

    public TreeNode helper(int[] preorder, int[] inorder,int start,int end)
    {
        if(start>end)
            return null;

        int rootVal = preorder[idx];

        int rootidx = map.get(rootVal);

        TreeNode root= new TreeNode(rootVal);

        idx++;

        root.left= helper(preorder,inorder,start,rootidx-1);

        root.right= helper(preorder,inorder,rootidx+1,end);

        return root;

    }
}