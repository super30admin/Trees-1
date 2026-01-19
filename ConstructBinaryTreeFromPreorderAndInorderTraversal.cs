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

//  Time Complexity:
// O(n)

// Space Complexity:
// O(n)

// We use preorder to get the root and a map to find its position in the inorder array.

// Everything before that index in inorder goes to the left subtree, rest to the right.

// We recurse left first (because preorder is root-left-right), then build the right subtree.
public class Solution
{
    int idx;
    Dictionary<int, int> dict = new Dictionary<int, int>();
    public TreeNode BuildTree(int[] inorder, int[] postorder)
    {
        idx = postorder.Length - 1;
        for (int i = 0; i < inorder.Length; i++)
        {
            dict[inorder[i]] = i;
        }
        return helper(inorder, postorder, 0, postorder.Length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int left, int right)
    {
        if (right < left)
            return null;
        TreeNode root = new TreeNode(postorder[idx]);
        idx--;
        int rootidx = dict[root.val];
        root.right = helper(inorder, postorder, rootidx + 1, right);
        root.left = helper(inorder, postorder, left, rootidx - 1);

        return root;
    }
}