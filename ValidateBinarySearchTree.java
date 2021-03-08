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
/*

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    private boolean validate(TreeNode node, Integer low, Integer high){
        //Check Node
        if(node == null){
            return true;
        }
        
        //Check node value
        if( (low!=null && node.val<= low) || (high != null && node.val>=high)){
            return false;
        }
        
        //Check Ls and RS
        return validate(node.left, low, node.val) && validate(node.right, node.val,high); 
    }
}

*/



class Solution {
    public boolean isValidBST(TreeNode root) {
        // call valiadte funtion to check if the given tree is valid or not
       return validate(root, Long.MIN_VALUE, Long.MAX_VALUE); 
            
    }
    
    private boolean validate(TreeNode node,long min, long max){
        
        //to handle edge cases or leaf nodes
        if(node == null){
            return true;
        }
        
        // checking if the value is not in the range
        //then return false
        if(node.val<= min || node.val>=max){
            return false;
        }
        
        //check left and right subtrees of each node
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}

// n --> number of nodes
// h --> height of the tree

// Time Complexity: O(n)
// Space Complexity: O(h)