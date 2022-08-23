// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes

class Solution {
    public boolean isValidBST(TreeNode root) {
        
        //crete a stack
        Stack<TreeNode> st = new Stack<>();
        
        TreeNode prev = null;
        //itertate till stack is empty
        while(!st.isEmpty() || root!= null){
          // add value to the stack
          // make the root as left node
            while(root!= null){
               st.push(root);
                root= root.left;
            }
          //pop the root
            root = st.pop();
          //previous values should be greater than root value
            if(prev!= null && prev.val >= root.val)
            {
                return false;
            }
          
            prev = root;
          //go for right side of the tree
            root = root.right;
        }
        return true;
    }
}
