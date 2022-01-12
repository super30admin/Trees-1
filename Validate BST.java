//Time complexity: O(n), n=number of roots
//Space complexity: O(1)
class Solution {
    boolean flag=true;
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
        
    }
    public boolean inOrder(TreeNode root)
    {
        
        if(root==null)
            return true;
        System.out.println(root.val);
        boolean left= inOrder(root.left);
        if(prev!=null && prev.val>=root.val)
        {
            flag= false;
            return flag;
        }
        
        prev=root;
        boolean right= inOrder(root.right);
        System.out.println(left+" "+right);
        return left && right;
        
    
    }
}
