package BST;// Time Complexity : O(n)
// Space Complexity : O(h) h is the height of the tree
// Did this code successfully run on Leetcode : Yes

public class ValidateBinarySearchTreeUsingPrev {
    boolean flag;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inOrder(root);
        return flag;
    }

    public void inOrder(TreeNode root){

        if(root == null) return;

        if(flag)
            inOrder(root.left);

        if(prev!=null && prev.val >= root.val)
        {
            flag = false;
        }
        prev = root;

        if(flag)
            inOrder(root.right);
    }

}
