
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


//****VALIDATE BINARY SEARCH TREE- MIN MAX SOLUTION***
//Time complexity:o(n);
//Space complexity:o(h);
//LeetCode runnable:Y
//Any doubts:N

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
        
        
        
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max)
    {
        //BASE:
        if(root==null)
        {
            return true;
        }
        if(min!=null && root.val<=min) return false;
        if(max!=null && root.val>=max) return false;
        
        
        //LOGIC:
        boolean left=helper(root.left, min, root.val);
        
        boolean right=helper(root.right, root.val, max);
        
        return left && right; 
        
    }
}
