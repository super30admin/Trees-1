/*
  Time complexity: O(n)
  Space complexity: O(n)

  Code ran successfully on Leetcode: Yes

  Approach: The preorder array is used to find the root at each level while the inorder array is converted into a dictionary and the root index values are used to construct the binary tree.

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
public class Solution {
    int[] preorder;
    int[] inorder;
    int preIndex;

    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        Dictionary<int,int> dict = new();
        int index = 0;
        

        foreach(int i in inorder)
            dict[i] = index++;

        return helper(0,inorder.Length-1, dict);
    }

    private TreeNode helper(int start, int end, Dictionary<int,int> dict)
    {
        if(start>end)
            return null;

        int r = preorder[preIndex];
        preIndex++;
        TreeNode root = new TreeNode(r);
        int index = dict[r];

        root.left = helper(start,index-1, dict);
        root.right = helper(index+1, end, dict);

        return root;
    }
}
