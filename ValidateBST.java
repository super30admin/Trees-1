//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        Inorder(root);
        return flag;
    }
    private void Inorder(TreeNode root){
        if(root==null||flag==false) return;
        Inorder(root.left);
        if(prev!=null&&prev.val>=root.val){
            flag=false;
        }
        prev=root;
        Inorder(root.right);
    }
}