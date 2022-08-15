//TC:O(n)
//SC:O(1)
//leecode : successfull

class Solution {
    TreeNode prev;
     boolean flag;
    public boolean isValidBST(TreeNode root) {
       flag = true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        if(root==null)
            return;
        if(flag){
            inorder(root.left);
        }
        if(prev!=null && prev.val >= root.val){
            flag = false;
            return;
        }
        prev = root;
        if(flag){
            inorder(root.right);
        }
        
    }
}