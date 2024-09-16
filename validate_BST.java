// Time Complexity : O(N) visiting each nodes
// Space Complexity : O(N) worst case we will visit all nodes, so height of tree becomes N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't do before class as usual. 


// Your code here along with comments explaining your approach

//recursive solution
//start with recursive call in main function
//first find root and check if it's null, if yes then return true
// then compare the node value (root in first case) whether it is lower or equal to(<=) the lowest value and whether it's higher or equal to (>=) the higher value. If yes, return false
//else repeat/return the recursive call for both node.left and node.right while updating the high and low respectively.


class Solution {
    public boolean isValidBST(TreeNode root) {
        //recursive call starts
        return validate(root, null, null);
    }
    
    
    private boolean validate(TreeNode node, Integer low, Integer high){
        //node check
        if(node == null) return true;
        
        //compare the nove value with lowest and highest vals
        if((low != null && node.val <= low) || (high != null && node.val >= high)){
            return false;
        }
        
        //repeat recursive calls for left and right side
        return validate(node.left, low, node.val) && validate(node.right, node.val,high);
    }
}