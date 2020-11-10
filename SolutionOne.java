
// Time Complexity :O(n)
// Space Complexity :O(h) height of the tree
// Did this code successfully run on Leetcode : yes
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
class Solution {
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {

       /* Stack<TreeNode> stack=new Stack<>();
        TreeNode prev=null;

        while(root!=null || !stack.isEmpty())
        {
            while(root!=null)
            {
                stack.push(root);
                root=root.left;
            }

            root=stack.pop();

            if(prev!=null&&prev.val>=root.val)
                return false;

            prev=root;
            root=root.right;

        }

        return true;*/

        return inOrder(root);
    }

    private boolean inOrder(TreeNode root)
    {

        if(root==null)
            return true;

        if(inOrder(root.left)==false)
            return false;


        if(prev!=null&&prev.val>=root.val)
            return false;

        prev=root;
        return inOrder(root.right);
    }

}