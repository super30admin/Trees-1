/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //recursive
    /*
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
return helper(root);
    }
    private boolean helper(TreeNode root){
        if(root==null) return true;
        if(helper(root.left)==false) return false;
        if(prev!=null && prev.val>root.val) return false;
        prev=root;
        return helper(root.right);*/
        //iterative
        public boolean isValidBST(TreeNode root) {
        TreeNode prev=null;
        Stack<TreeNode> st=new Stack<>();
        while(!st.isEmpty()|| root!=null){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            if(prev!=null && prev.val>=root.val){
                return false;
            }
            prev=root;
            root=root.right;
        }
        return true;
    }
}