
// Time Complexity : o(n)
// Space Complexity : o(1) 
// Space Complexity : o(h) for recursive  stack
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
// without using boolean flag
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    private boolean inorder(TreeNode root){
        if(null == root) return true;
        
        if(false == inorder(root.left)) return false;
        if(prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        
        return inorder(root.right);
    }
}
//nonrecursive inorder 
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && prev.val >= root.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}
