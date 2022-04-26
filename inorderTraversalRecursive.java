// observe how simple recursive solution for inoder traversal really is
// if we observe this and iterative solution we find that both are very similar on further observations
// we find that both recursive and iterative solutions pop at same time
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        inorder(root);
        return true;
    }
    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
}