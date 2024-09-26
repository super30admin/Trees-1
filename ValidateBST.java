//Recursive Approach
class Solution {
    public boolean isValidBST(TreeNode root) {
     
        return helper(root, null, null);
   
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max)
    {
        if(root == null)
            return true;
        
        if((max != null && root.val >= max) || (min != null && root.val <= min)) 
            return false;
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max); 
    }
    
}


// Iterartive Approach
// class Solution {
//     public boolean isValidBST(TreeNode root) {
     
//         if(root == null)
//             return true;
        
//         Stack<TreeNode> stk = new Stack<>();
//         TreeNode prev = null;
        
//         while(!stk.isEmpty() || root != null)
//         {
//             while(root != null)
//             {
//                 stk.push(root);
//                 root = root.left;
//             }
        
//             root = stk.pop();
//             if(prev !=null && root.val <= prev.val) return false;
//             prev = root;
//             root = root.right;
//         }
        
//         return true;
//     }
    
// }
