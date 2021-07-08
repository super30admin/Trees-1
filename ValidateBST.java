// Time Complexity : O(n)
// Space Complexity : O(h) where h is height of the tree
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach

//iterative approach
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode prev = null;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            
               root = stack.pop();
               if(prev!=null  && prev.val>= root.val) return false;
               prev = root;
               root = root.right;
            
            
        }
        
        return true;
        
    }
}


//recursive approach
// Time Complexity : O(n)
// Space Complexity : O(h) where h is height of the tree
// Did this code successfully run on Leetcode : yes

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    
    
    public boolean helper(TreeNode root){
        //base
        if(root == null )
            return true;
        //logic
         if(helper(root.left) == false) return false;
         if(prev!= null && prev.val >= root.val)
            return false;
          prev = root;
          return helper(root.right);
          
    }
}
