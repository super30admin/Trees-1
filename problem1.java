class Solution {
    //time- o(n)- #nodes
    //space-O(n)
    public boolean isValidBST(TreeNode root) {
     
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean check(TreeNode root, long minVal, long maxVal){
        
        if(root==null) return true;
    
        //if not in range return false
        
      if(root.val>=maxVal || root.val<=minVal) return false;
        
        return check(root.left, minVal, root.val) && check(root.right, root.val, maxVal);
          
        
    }
}