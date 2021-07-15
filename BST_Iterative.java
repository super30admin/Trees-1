// Time Complexity : O(n), n=number of nodes
// Space Complexity : O(H), H=Height of the tree
// Did this code successfully run on Leetcode : Yes
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root != null || !st.isEmpty()) {
            //left
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            //root node
            root = st.pop();
            //validating BST
            if(prev != null && prev.val >= root.val)
                return false;
            prev = root;
            //right 
            root = root.right;
        }
    return true;
    }
}