// Time Complexity : O(N)
// Space Complexity : O(h) height of BST. h can be n in worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ValidateBinaryTree
{
    public static void main(String[] args) {

    }
    /*
    boolean isValidBST = true;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root)
    {
        helper(root, null, null);
        return isValidBST;
    }

    public void helper(TreeNode root, Integer minValue, Integer maxValue)
    {
        if(root == null)
            return;

        if((minValue != null && root.val <= minValue ) || (maxValue != null && root.val >= maxValue))
        {
            this.isValidBST = false;
            return;
        }

        if(isValidBST)
            this.helper(root.left, minValue, root.val);
        if(isValidBST)
            this.helper(root.right, root.val, maxValue);
    }

    public void inorder(TreeNode root)
    {
        if(root == null)
            return;
        inorder(root.left);
        if(prev != null && root.val <= prev.val)
            isValidBST = false;

        prev = root;
        inorder(root.right);
    }

     */
}
