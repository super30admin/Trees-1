// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes

import java.util.HashMap;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,map);
    }
    private TreeNode helper(int[] preorder, int start, int end, HashMap<Integer,Integer> map){
        if(start > end) return null;
        int currVal = preorder[index];
        index+=1;
        int currIdx = map.get(currVal);
        TreeNode node = new TreeNode(currVal);
        node.left = helper(preorder, start, currIdx - 1, map);
        node.right = helper(preorder, currIdx + 1, end, map);
        return node;
    }
}