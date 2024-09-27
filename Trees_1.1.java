//Time Complexity: O(n) - only one traversal along all the nodes
//Space Complexity: O(n) - since the recursive function is called for every node in the stack
//Leetcode: No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return recursive(root, null, null);
    }
    
    public boolean recursive(TreeNode node, int low, int up){
        if(node == null)return true;//ending condition
        
        if(low ! = null && node.val <= low)return false;
        if(up ! = null && node.val >=up )return false;
        
        //passing left and right nodes to the recursive funcrions
        
        if(!recursive(node.right, node.val, up))return false;
        if(!recursive(node.left, low, node.val))return false;
        
        return true;
    }
}