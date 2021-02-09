/**
Time Complexity: O(n), n = no of nodes
space: O(d) where d is depth of the tree

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
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        //base condition
        if(root == null)
            return true;
        return inOrder(root);
        
    }
    
    private boolean inOrder(TreeNode node ){
        //base case
        if(node == null)
            return true;
        
        //traversal
        if(inOrder(node.left) == false)
            return false;
        
        //logic
        if(prev != null && prev.val >= node.val)
            return false;
        prev = node;
        return inOrder(node.right);
    }
    
}