Time Complexity-O(n)-n-No of nodes
Space Complexity-O(1)
class Solution {
       long min=Long.MIN_VALUE;
       long max=Long.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
       return helper(root,min,max);
        
    }
    public boolean helper(TreeNode root,long min, long max)
    {
      if(root==null)
          return true;
       if(root.val>=max || root.val<=min) return false;
       return (helper(root.left,min,root.val) && helper(root.right,root.val,max));
      
    }
}
