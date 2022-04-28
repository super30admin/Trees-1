//time - O(n)
//space - O(h)
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }
    private boolean inorder(TreeNode root){
        if(root==null) return true;

        boolean left = inorder(root.left);

        if(prev!=null && prev.val >= root.val) return false;

        prev = root;

        boolean right = inorder(root.right);

        return left && right;
    }
}