// Time Complexity : O(N) , N is number of nodes
// Space Complexity : O(h) , h is height of the Tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


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
    public boolean isValidBST(TreeNode root) {
        
        Stack<TreeNode> s = new Stack<>();
        TreeNode prev = null;
        
        while (root != null || !s.isEmpty()) {
            
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            
            root = s.pop();
            
            if(prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
        
    }
}