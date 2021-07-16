// Time Complexity : O(N) 
// Space Complexity : O(N) [because, we use hashMap]
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
    //initially hashMap and preorder Index global, because its accessed by helper method
    Map<Integer, Integer> inorderMap;
    //no need to set to zero, because int value is initially zero only
    int preorderIdx;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        
        //create hashMap of Inorder
        inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        
        //call helper method and return it
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    
    //recursive approach
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //base
        if(start > end)
            return null;
        //logic
        //find root in preorder first
        int rootVal = preorder[preorderIdx];
        //increment the preorder index now for next sub root
        preorderIdx++;
        //create the tree with root
        TreeNode root = new TreeNode(rootVal);
        
        //find root in inorder
        int rootIdx = inorderMap.get(rootVal);
        
        //divide left and right subtree
        root.left = helper(preorder, inorder, start, rootIdx-1);
        root.right = helper(preorder, inorder, rootIdx+1, end);
        
        return root;
        
    }
}

