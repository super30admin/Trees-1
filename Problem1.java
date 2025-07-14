class Solution {
    boolean isValid ;
    public boolean isValidBST(TreeNode root) {
        isValid = true;
        check(root,null,null);
        return isValid;
    }

    private void check(TreeNode root,Integer min,Integer max)
    {
        if(root==null){
            return;
        }

        check(root.left,min,root.val);
        
        if((min!=null && min>=root.val)||(max!=null && max<=root.val)){
            isValid = false;
        }
        check(root.right,root.val,max);

    }
}
