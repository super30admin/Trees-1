
// Time Complexity : O(n)
//Space Complexity : O(h) 
//Did this code successfully run on Leetcode : Yes
class Solution {
    public boolean isValidBST(TreeNode root) {
       Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
                
            }
            
            root = stack.pop();
            if(prev != null && root.val <= prev.val  ) return false;
            prev = root;
            root = root.right;
        }
        
        return true;
    }
}

//----------Recursive Solution ----------------


class Solution {
    TreeNode prev;
   public boolean isValidBST(TreeNode root) {
        return inOrder(root);
   }
   
   private boolean inOrder(TreeNode root){
       //base 
       
       if(root == null) return true;
       
       // logic
      
       if(inOrder(root.left) == false) return false;
       
      // while(root != null || !stack.isEmpty()){
        //   while(root != null){
          //     stack.push(root);
            //   root = root.left;
               
           //}
       
           
           //root = stack.pop();
           if(prev != null && root.val <= prev.val) return false;
           prev = root;
          return  inOrder(root.right);
   }   
}