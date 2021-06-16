// Time Complexity : O(N)
// Space Complexity : O(H) : H = height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

// Use recursion to check if a node is less than max and more than the min for that specific node and the subtree
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root,null,null);
    }
    
    
    public boolean validateBST(TreeNode root, Integer min, Integer max){
        if(root==null)
            return true;
        
        if((min!=null && root.val <= min) || (max!=null && root.val >= max))
            return false;
        
        return validateBST(root.left,min,root.val) && validateBST(root.right,root.val,max);
    }
}