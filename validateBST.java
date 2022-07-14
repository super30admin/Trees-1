// Time Complexity : o(n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach


class Solution {
    
    //boolean isValid;
    public boolean isValidBST(TreeNode root) {
        
       // isValid=true;
       
        
        return  helper(root,null,null);
    }
    
    private boolean helper(TreeNode root,Integer min,Integer max){
      
        //reccursive should continue to search right node if left is null so
        if(root==null){
            return true;
        }
        
        //base case
        
        if(min!=null && root.val<=min){
           // isValid=false;
            return false;
        }
        if(max!=null && root.val>=max){
          //  isValid=false;
            return false;
        }
        
        boolean case1=helper(root.left,min,root.val);
        boolean case2=helper(root.right,root.val,max);
        
        return case1&&case2;
    }
}