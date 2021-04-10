//Time Complexity -O(n)
//Space Complexity-O(n) because of stack 
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        prev =null;
        return validate(root);
    }
    boolean validate(TreeNode root){
        if(root==null) return true;
        if(validate(root.left)==false) return false;
        if(prev!=null && prev.val>=root.val) return false;
        System.out.print(root.val);
        prev=root;
        return validate(root.right);
    }
}