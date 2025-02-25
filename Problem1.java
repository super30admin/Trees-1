class Problem1 {
    TreeNode prev;
    boolean flag=true;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return flag;

    }
    public void inOrder(TreeNode root) {
        if(root==null) return;
        inOrder(root.left);
        if(prev!=null && prev.val>=root.val){
            flag= false;
            return;
        }

        prev=root;
        if(flag) inOrder(root.right);
        return ;




    }

}