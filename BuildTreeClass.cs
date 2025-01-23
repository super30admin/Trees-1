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
public class Solution
{
    int index;
    Dictionary<int, int> lookup;
    public TreeNode BuildTree(int[] preorder, int[] inorder)
    {
        if (preorder == null || preorder.Length == 0 || inorder == null || inorder.Length == 0 || preorder.Length != inorder.Length)
        {
            return null;
        }

        lookup = new Dictionary<int, int>();
        for (int i = 0; i < inorder.Length; i++)
        {
            lookup.Add(inorder[i], i);
        }

        return CreateTree(preorder, 0, preorder.Length - 1);
    }

    public TreeNode CreateTree(int[] preorder, int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index]);
        var rootIndex = lookup[preorder[index]];
        index++;

        root.left = CreateTree(preorder, start, rootIndex - 1);
        root.right = CreateTree(preorder, rootIndex + 1, end);
        return root;
    }
}