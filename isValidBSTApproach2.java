// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    boolean result;
    public boolean isValidBST(TreeNode root) {
        if(root == null )
            return true;
    
        result = true; //by default it is true and we will change in helper
        
        helper(root, null, null);
        return result;
        
    }
    
    private void helper(TreeNode root, Integer min, Integer max){
        
        //base
        if(root == null)
            return;
        
        //for left side the range will be the min of the parent till the value of the parent
        helper(root.left, min, root.val);
        
        //at the root check if it fits the range
        if((max != null && root.val >= max) || (min != null && root.val <= min)){
            result = false;
            return;
        }
        //the range for the right node would be the parent's value till the max of the parent
        helper(root.right, root.val, max);
    }
}