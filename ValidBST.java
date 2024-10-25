class Solution {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag=true;
        helper(root);
        return flag;   
    }
    
    private void helper(TreeNode root){
        //base case
        if(root==null) return;
        
        helper(root.left);
        if(prev!=null && prev.val >=root.val){
            flag=false;
        }
        prev=root;
        helper(root.right);
        
    }
}