// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

public class isValidBSTRecursive {
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return inorder(root);

    }

    private boolean inorder(TreeNode root){
        if(root == null)
            return true;
        if(inorder(root.left) == false)
            return false;
        if(prev != null && prev.val >= root.val)
            return false;
        prev = root;

        return inorder(root.right);
    }

}