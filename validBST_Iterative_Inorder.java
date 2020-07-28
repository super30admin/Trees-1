// Time Complexity : O(n) where n= all values in the array 

// Space Complexity : O(h) height of the stack


class Solution {
    public boolean isValidBST(TreeNode root) {
        // First way
        // Iterative using inorder
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev=null;
        
        while(root!=null || !stack.isEmpty())
        {
            /* Left Most Element */
            while(root!=null)
            {
                stack.push(root);
                root=root.left;
            }
            
            /* Pop From Stack */
            root=stack.pop();
            
            if(prev != null && prev.val>=root.val)
                return false;
            
            prev=root;
            
            /* Go Right */
            root=root.right;
            
        }
        
        return true;
    }
}