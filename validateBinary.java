//time complexity:O(n)
//space complexity:O(h)

class Solution {
     
     boolean isValid;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return false;
        isValid=true;
        inorder(root);
        return isValid;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && prev.val >=root.val){
            isValid=false;
        }
        prev=root;
        inorder(root.right);
        
    } 
}