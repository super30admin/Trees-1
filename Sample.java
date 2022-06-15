
//****VALIDATE BINARY SEARCH TREE- RECURSIVE SOLUTION***
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
//****VALIDATE BINARY SEARCH TREE- ITERATIVE SOLUTION***
//Time complexity:o(n);
//Space complexity:o(h);

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode prev=null;
        Stack<TreeNode> st=new Stack<>();
        
        while(root!=null || !st.isEmpty())
        {
            while(root!=null)
            {
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            if(prev!=null && prev.val>=root.val)
            {
                return false;
            }
            prev=root;
            root=root.right;
        }
        return true;
        
    }
}


