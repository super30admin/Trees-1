//Time complexity = o(n^2)
//Space complexity = o(n)

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
    int preidx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
        {
            return null;
        }
        return helper(inorder, preorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] inorder,int[] preorder, int left, int right)
    {
        int idx = 0;
        if(left > right) return null;
        if(preidx>preorder.length-1) return null;
        int rootval = preorder[preidx];
        preidx++;
        TreeNode root = new TreeNode(rootval);
        
        

        for(int i=0; i<inorder.length; i++)
        {
            if( inorder[i] == rootval)
            {
                idx = i;
            }
        }
        root.left = helper(inorder, preorder, left, idx-1);
        root.right = helper(inorder, preorder, idx+1, right);
        return root;
    }
}