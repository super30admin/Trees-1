//Did this code run on LeetCode: Yes

public class ValidateBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
}
    private void inorder(TreeNode root){
        //base
        if(root == null)
            return;
        //logic
        inorder(root.left);
        if(prev != null && prev.val >= root.val)
        {
            flag = false;
        }
        prev = root;
        inorder(root.right);
}
}