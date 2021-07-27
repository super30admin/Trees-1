// Time Complexity :O(N)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    boolean result;
    public boolean isValidBST(TreeNode root) {
        
        //at every node ,identify the min and max or the range 
        //if you look at the min and max pattern for left node it is min,root
        //the min,max pattern identified for right node is root,max
        
        
        if(root == null) return true;
        
        result = true;
        helper(root,null,null);
        return result;
    }
    
    private void helper(TreeNode root, Integer min, Integer max){
        //base case
        if(root == null) return;
        
        helper(root.left, min, root.val);
        //Return false if root is not within the range
        if((max != null && root.val >=max)||(min != null && root.val <= min))
        {
            result = false;
            return ;
        }
        
        helper(root.right, root.val, max);
    }
}
