// Time Complexity o(h) Space complexity o(h)

class Solution {
    TreeNode prev;
    boolean flag=true;
    public boolean isValidBST(TreeNode root) {
       return helper(root);

    }
    public boolean helper(TreeNode root){
        if(root==null) return true;
        boolean left=helper(root.left);
        if(left==false) return false;
        if(prev != null && prev.val>=root.val){
            return false;
        }
        prev=root;
        return helper(root.right);


    }
}