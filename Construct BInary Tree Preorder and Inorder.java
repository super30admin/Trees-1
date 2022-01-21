// Time Complexity : O(n)
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
    
    // for reducing time complexity
    HashMap<Integer, Integer> map;
    // pointer for preorder traversal
    int index;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // check if preorder array is null or empty
        if(preorder == null || preorder.length == 0) return null;
        
        // traverse through the inorder array and put it into Hash Map
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        // call recursive function
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        // base
        // check if start has crossed end
        if(start > end) return null;
        
        // logic
        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);
        // find index of rootVal in inorder array
        int rootIndex = map.get(rootVal);
        
        // call recursive function on left half
        root.left = helper(preorder, inorder, start, rootIndex - 1);
        // call recursive function on right half
        root.right = helper(preorder, inorder, rootIndex + 1, end);
        return root;
    }
}