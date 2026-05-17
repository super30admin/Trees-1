// Time Complexity : O(n)
// Space Complexity : O(n) = Space taken to build the hashmap
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

/*
    I use the preorder list to keep track of values of root nodes (Preorder = Root -> Recursively traverse left subtree -> Recursively traverse right subtree) and inorder list to obtain information about
    what nodes belong to the left subtree of a given node and what nodes belong to the right subtree of a given node. 
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
    private int index;
    private Dictionary<int, int> inorderLookup;

    public TreeNode BuildTree(int[] preorder, int[] inorder)
    {
        index = 0;
        inorderLookup = new();

        for (int i = 0; i < inorder.Length; i++)
        {
            inorderLookup[inorder[i]] = i;
        }

        return Helper(0, preorder.Length - 1, preorder);
    }

    public TreeNode Helper(int start, int end, int[] preorder)
    {
        // Base condition
        if (start > end)
        {
            return null;
        }

        int rootVal = preorder[index];
        index += 1;
        int inorderRootPosition = inorderLookup[rootVal];

        TreeNode temp = new TreeNode(rootVal);

        temp.left = Helper(start, inorderRootPosition - 1, preorder);
        temp.right = Helper(inorderRootPosition + 1, end, preorder);

        return temp;
    }
}