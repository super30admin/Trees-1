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
//TimeComplexity O(n)
//SpaceComplexity O(n)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> preMap = new HashMap<>();
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i = 0;i<preorder.length;i++)
        {
            preMap.put(preorder[i],i);
            inMap.put(inorder[i],i);
        }
        return helper(preorder,inorder,preMap,inMap,0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder,Map<Integer,Integer> preMap,Map<Integer,Integer> inMap,int pStart,int pEnd,int iStart,int iEnd)
    {
        //base
        if(pStart>pEnd)
        {
            return null;
        }
        //logic
        int nodeVal = preorder[pStart];
        TreeNode node = new TreeNode(nodeVal);
        //find left/right tree len from inorder
        int leftTreeLen = inMap.get(nodeVal) - iStart;
        int rightTreeLen = iEnd - inMap.get(nodeVal);
        //calculate left tree and adjust the params
        node.left = helper(preorder,inorder,preMap,inMap,pStart+1,pStart+leftTreeLen,iStart,inMap.get(nodeVal)-1);
        //calculate right tree and adjust the params
        node.right = helper(preorder,inorder,preMap,inMap,pStart+leftTreeLen+1,pEnd,inMap.get(nodeVal)+1,iEnd);
        //return
        return node;
    }
}