//time  : O(n)
//space : O(1) 
class Solution {
    boolean flag;
    TreeNode perv;
    public boolean isValidBST(TreeNode root) {
        
        this.flag = true;
        this.perv=null;
        helper(root);

        return flag;
    }

    private void helper(TreeNode root){
        //base
        if(root==null || !flag) return;
        //logic
        helper(root.left);
        if(perv!=null && perv.val>=root.val){
            flag = false;
        }
        perv = root;
        
        helper(root.right);
    }
}