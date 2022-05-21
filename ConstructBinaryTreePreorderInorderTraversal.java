// Time Complexity : O(N)
// Space Complexity : O(N)
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
    int i; //iterator index
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        i=0;
        inorderIndexMap = new HashMap<>();
        for(int index = 0; index < inorder.length; index++) 
            inorderIndexMap.put(inorder[index], index);
        return helper(preorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int left, int right) {
        //base
        if(left > right)
            return null;
        //logic
        int rootVal = preorder[i];
        i++;
        TreeNode root = new TreeNode(rootVal);
        
        root.left = helper(preorder, left, inorderIndexMap.get(rootVal) -1);
        root.right = helper(preorder, inorderIndexMap.get(rootVal) +1,right);
        return  root;
    }
}