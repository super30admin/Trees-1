// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
        
    }
    private boolean helper(TreeNode root,Integer min,Integer max){
        if(root == null){
            return true;
        }
        int val = root.val;
        if((min != null && val <= min) || (max != null && val >= max)){
            return false;
            
        }
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
        
        
    
    }
}
