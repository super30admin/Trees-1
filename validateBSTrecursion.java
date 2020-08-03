//time complexity: O(n) where n is the number of nodes of the tree
//space complexity: O(height of tree)
//executed on leetcode: yes

class Solution
{
    public boolean isValidBST(TreeNode root)
    {
        return helper(root,null,null);
    }
    public boolean helper(TreeNode root,TreeNode min,TreeNode max)
    {
        if(root==null) return true;
        if(max!=null && root.val>=max.val) return false; //checking left subtree
        if(min!=null && root.val<=min.val) return false; //checking right subtree
        if(!helper(root.left,min,root)) return false;
        return helper(root.right,root,max);
    }
}

