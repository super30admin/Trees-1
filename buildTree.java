// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
    int preStart = 0;
    Map<Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //hashmap to store inorder value, index of the value
         inorderIndexMap = new HashMap<>();
        
        for(int i=0; i< inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }
        
        return helper(preorder, 0, preorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int left, int right){
        
        //if no elements in tree, return null
        if(left > right)
            return null;
        
        int rootVal = preorder[preStart++];
        TreeNode root = new TreeNode(rootVal);
        
        //build left and right subtree
        root.left = helper(preorder, left, inorderIndexMap.get(rootVal)-1);
        root.right = helper(preorder, inorderIndexMap.get(rootVal)+1, right);
        
        return root;
        
    }
}