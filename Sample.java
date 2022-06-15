
//****VALIDATE BINARY SEARCH TREE***
//Time complexity:o(n);
//Space complexity:o(h);
//LeetCode runnable:Y
//Any doubts:N

class Solution {
    boolean flag=true;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return flag;
        
        
    }
    private void inorder(TreeNode root)
    {
        //Base case
        if(root==null)
        {
            return;
        }
        
        //Logic
        inorder(root.left);
        if(prev!=null && prev.val>=root.val)
        {
            flag=false;
        }
        prev=root;
        if(flag)
        {
            inorder(root.right);
        }
    }
}
