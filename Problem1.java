/**
 * Time complexity - O(h) where h is the height of the tree
 * Space complexity - O(1) if we don't consider recursive stack else O(h)
 */
class Solution {
    private Integer prev;
    public boolean isValidBST(TreeNode root) {
        /**
         Do inorder traversal and check if the previous value is greater than the current value
         **/
        return inorder(root);
    }

    public boolean inorder(TreeNode root)
    {
        if(root==null)
            return true;
        if(!inorder(root.left)) return false;
        if(prev!=null&&prev>=root.val) return false;
        prev=root.val;
        return inorder(root.right);
    }
}