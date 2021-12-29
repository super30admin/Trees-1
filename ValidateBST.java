//Time complexity : O(n)
//Space complexity : O(n)
// leetcode: success

class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
       return validate(root);
    }
    
    private boolean validate(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        boolean left = validate(root.left);
        if(left == false){
            return false;
        }
     
        if(prev != null && prev.val >= root.val){
            return false;
        }
       
        prev = root;
      
       return validate(root.right);
    }
}