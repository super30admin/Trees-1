
// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// https://leetcode.com/problems/search-a-2d-matrix-ii/
class Solution {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        //base
        if(null == root) return;
        //logic
        inorder(root.left);
        //st.pop()
        if(prev != null && prev.val >= root.val){
            flag = false;
        }
        prev = root;
        if(flag){
            inorder(root.right);
            //st.pop
        }
        
    }
}