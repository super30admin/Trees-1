// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :no
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        return inorder(root);
        // Stack<TreeNode> st = new Stack<>();
        // TreeNode prev =null;
        // while(root !=null || !st.isEmpty()){
        //     while(root !=null){
        //     st.push(root);
        //    root = root.left;
        // }
        // root = st.pop();
        
        // root = root.right;
    }
    
    private boolean inorder(TreeNode root){
        if(root == null)return true;
        
        if(inorder(root.left) == false)return false;
        if(prev != null && root.val <= prev.val)return false;
        prev = root;
        return inorder(root.right);
    }
}
