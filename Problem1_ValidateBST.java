// Time Complexity : o(n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
   /* public boolean isValidBST(TreeNode root) {
        
        return this.validBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    private boolean validBST(TreeNode root,long minValue,long maxValue)
    {
        if(root==null)
            return true;
        if(( (root.val <= minValue)) || ( (root.val >= maxValue)))
            return false;
       return validBST(root.left,minValue,root.val) && validBST(root.right,root.val,maxValue);
            
    }
    */
    //inorder iterative
    public boolean isValidBST(TreeNode root) {
        TreeNode prev=null;
        Stack<TreeNode> stack=new Stack<>();
        
        while(root!=null || !stack.isEmpty())
        {
            //left
            while(root!=null)
            {
                stack.push(root);
                root=root.left;
            }
            //root
            root=stack.pop();
            if(prev!=null && (prev.val>=root.val))
                return false;
            prev=root;
            System.out.println(root.val);
            //right
            root=root.right;
        }
        return true;
    }
    
}