class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag=true;
        if(root==null || (root.left==null && root.right==null)) return true;
        helper(root);
        return flag;
    }
    private void helper(TreeNode root){
        if(root==null ) return;
        
        helper(root.left);
        
        if(prev!=null && root.val<=prev.val){
            flag=false;
        }
        prev=root;
        helper(root.right);
        
    }
}
