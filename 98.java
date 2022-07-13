class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean validate(TreeNode node,long min,long max)
    {
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;
        
        return validate(node.left,min,node.val) && validate(node.right,node.val,max);
    }
}