//time complexity:O(N)
//space complexity:O(1)

class ValidateBST {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        prev=null;
        isValid=true;
        inorder(root);
        
        return isValid;
        
    }
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        if(prev!=null && prev.val>=root.val)
        {
            isValid=false;
        }
        prev=root;
        inorder(root.right);
    }
}