// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidBST(TreeNode root) {
        double max = Double.POSITIVE_INFINITY;
        double min = Double.NEGATIVE_INFINITY;
        return helper(root,min,max);
    }
    
    public boolean helper(TreeNode node, double min, double max){ 
      if(node == null){
          return true;
      }
      
      if(node.val>=max||node.val<=min){
          return false;
      }
        
      boolean isLeftBST = helper(node.left,min,node.val);
      boolean isRightBST = helper(node.right,node.val,max);
        
      return (isLeftBST && isRightBST);
    }
}

