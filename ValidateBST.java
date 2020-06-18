// Time Complexity : O(n) n is number of nodes
// Space Complexity :O(1) for recursive solution
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class ValidateBST {
    //Recursive approach
    TreeNode prev = null;
     public boolean isValidBST(TreeNode root) {
         return inorder(root);
     }
    private boolean inorder(TreeNode root)
    {
        if(root==null) return true;
        
        if(inorder(root.left)==false) return false;;
        if(prev!=null && prev.val>=root.val) return false;
        prev = root;
        return inorder(root.right);
    }
    
    //Using single stack
    // public boolean isValidBST(TreeNode root) {
    //     Stack<TreeNode> st = new Stack<>();
    //     TreeNode prev = null;
    //     while(root!=null || !st.isEmpty()){
    //         while(root!=null)
    //         {
    //             st.push(root);
    //             root=root.left;
    //         }
    //         root = st.pop();
    //         if(prev!=null && root.val<=prev.val) return false;
    //         prev = root;
    //         root=root.right;
    //     }
    //     return true;
    // }
    
//Using two stacks
//     public boolean isValidBST(TreeNode root) {
        
//         if(root==null) return true;
//         Stack<Integer> stack = new Stack<>();
//         performInorder(root,stack);
        
//         while(stack.size()!=1){
//             if(stack.pop()<=stack.peek()) return false;
//         }
//         return true;
//     }

//     private void performInorder(TreeNode root, Stack<Integer> stack)
//     {
//         if(root==null) return;
        
//         performInorder(root.left,stack);
//         stack.push(root.val);
//         performInorder(root.right,stack);
//     }
}
