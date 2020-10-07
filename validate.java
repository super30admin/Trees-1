//Time complexity: O(n)
//space complexity: O(n)


class Solution {
    public boolean isValidBST(TreeNode root) {
         return helper(root,null,null);
    }
    public boolean helper(TreeNode node,Integer min,Integer max){
        if(node==null) return true;
        
        int val = node.val;
        if(min != null && val <= min) return false; 
        
        if(max != null && val >= max) return false;
        
        return helper(node.left,min,val) && helper(node.right,val,max);
    
}}