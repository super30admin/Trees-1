//Validate BST - Recursive with min & max range
//Space complexity : o(n)
//Time complexity : o(n)
public class Problem1 {
    public boolean isValidBST(TreeNode root) {
        
        //Cannot take min & max as Integer.MIN_VAL and Integer.MAX_VAL respectively because of the constraint -2^31 <= Node.val <= 2^31 - 1
        // the root can have min & max value hence this can fail
        return helper(root,null,null);
        
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max){
        if(root==null){
            return true;
        }
        
        if((max!=null && root.val>=max) || (min!=null && root.val<=min)){
            return false;
        }

        return  helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
  
}

//Validate BST - Recursive with inorder & previous value
//Space complexity : o(n)
//Time complexity : o(n)
class Solution {
    //Need to store as global because we need to maintain the state of prev from each recursive call
    public Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
        
    }
    
    private boolean inorder(TreeNode root){
        if(root==null){
            return true;
        }
         if(!inorder(root.left)){
             return false;
         }
        
         //inorder should give an ascending order, so if prev is not less than or equal to root, then it should return false
         if(prev!=null && root.val<=prev){
             return false;
         }
        
         prev=root.val;
        
         return inorder(root.right);
        
    }
  
}