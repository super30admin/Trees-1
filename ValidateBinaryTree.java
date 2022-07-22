/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// time complexity 0(n)
// space complexity 0(n)
class Solution {
    TreeNode prev;
    boolean isValid= true;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        Inorder(root);
        return isValid;
    }

    private void Inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        Inorder(root.left);
        if(prev!=null && prev.val>=root.val)
        {
            isValid=false;
            return;
        }
        prev=root;
        Inorder(root.right);

    }

}

