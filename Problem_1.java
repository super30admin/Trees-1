// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    
    // Iterative Solution 
    public boolean isValidBST(TreeNode root) {
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        
        while(root != null || !st.isEmpty()){
            
            while(root != null){
                st.push(root);
                root = root.left;
            }
            
            root = st.pop();
            
            if(prev!= null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        
        return true;
}}