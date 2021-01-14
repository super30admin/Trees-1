// Time Complexity : O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes


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
    HashMap<Integer, Integer> map;
    int index; //pre order index
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return helper(preorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int start, int end){
        //base
        if(start > end)
            return null;
        //logic
        int rootValue = preorder[index]; index++;
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = map.get(rootValue);
        root.left = helper(preorder, start, rootIndex-1);
        root.right = helper(preorder, rootIndex+1, end);
        return root;
    }
}