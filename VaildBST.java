/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        
        return helper(root,null,null);
        
//        return helper(root);
     
        
        
    }
    
    private boolean helper(TreeNode root, Integer max , Integer min)
    {
        
        //base
        if(root==null)
        {
            return true;
        }
        if((max!=null && root.val >=max) || (min!=null && root.val<=min ))
            return false;
        
      
        if(helper(root.left,root.val,min)==false)
        {
            return false;
        }
        
        
        return (helper(root.right,max,root.val));
        
//         if(root==null)
//         {
//             return false;
//         }
        
//         helper(root.left);
        
//         if(prev!=null)
//         {
//         if(prev.val >= root.val)
//         {
//             isValid = false;
//             return;
//         }
//         }
//         prev = root;
//         helper(root.right);
//     }
}
}