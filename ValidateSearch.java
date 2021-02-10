// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// We are doing the inorder traversal on the tree and it will be sorted , if we see that the next element is smaller 
//than previous we return false;
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
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
            stack.push(root);
            root = root.left;
        }
        
        TreeNode curr = stack.pop();
        
        if(prev!=null && prev.val>=curr.val){
            return false;
        }
        prev = curr;
            
        root = curr.right;
        
    }
        return true;
}
}