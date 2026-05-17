// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

/*
    I perform DFS on the tree and at each node, I check if the value of every right child is greater than that of its parent and value of left child is smaller than that of it's parent. 
    I perform this logic checking recursively so that the value of all nodes in left subtree is smaller than the value of the root node and value of all nodes in right subtree is greater
    than the value of the root node.
*/

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
    public bool IsValidBST(TreeNode root)
    {
        return Helper(root, Int64.MinValue, Int64.MaxValue);
    }

    public bool Helper(TreeNode root, long min, long max)
    {
        if (root == null)
        {
            return true;
        }

        if (root.val <= min || root.val >= max)
        {
            return false;
        }

        return Helper(root.left, min, root.val) && Helper(root.right, root.val, max);
    }
}