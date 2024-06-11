//time O(n)
//space O(h) recursive stack space
//approach: DFS

class Solution {
    boolean flag = true;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return flag;
    }

    private void inorder (TreeNode root) {
        //base
        if(root == null) return;

        //logic 
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root;
        inorder(root.right);
    } 
}
