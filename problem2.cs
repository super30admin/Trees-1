/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        if(preorder.Length == 0)
        {
            return null;
        }
        int rootValue=preorder[0];
        int rootIndex = -1;
        for(var i=0;i<inorder.Length;i++)
        {
            if(rootValue == inorder[i])
            {
                rootIndex = i;
                break;
            }
        }
        int[] inLeft = new int[rootIndex];
        Array.Copy(inorder, 0, inLeft, 0, rootIndex);
        int[] inRight = new int[inorder.Length - rootIndex - 1];
        Array.Copy(inorder, rootIndex + 1, inRight, 0, inRight.Length);
        int[] preLeft = new int[inLeft.Length];
        Array.Copy(preorder, 1, preLeft, 0, inLeft.Length);
        int[] preRight =  new int[inRight.Length];
        Array.Copy(preorder, 1 + inLeft.Length, preRight, 0, inRight.Length);
        TreeNode root = new TreeNode(rootValue);
        root.left = BuildTree(preLeft,inLeft);
        root.right = BuildTree(preRight,inRight);

        return root;

    }
}