// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    
    public boolean inorder(TreeNode root){
        //base
        if(root == null ) return true;
        //logic
        if(!inorder(root.left)) return false;
        if(prev!=null && prev.val>=root.val) return false;
        
        prev = root;
        return inorder(root.right);
        
    }
    //Approach1
//     public boolean isValidBST(TreeNode root) {
//         return checkBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
//     }
//     public boolean checkBST(TreeNode root, long min, long max){
//         if(root == null) return true;
        
//         if( min>=root.val ) return false;
//         if( max<=root.val) return false;
        
//         return checkBST(root.left,min,root.val) && checkBST(root.right,root.val,max);
//     }
}