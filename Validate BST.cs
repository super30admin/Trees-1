/*
  Time complexity: O(n)
  Space complexity: O(h)

  Code ran successfully on Leetcode: Yes

  Approach: Using a recursive solution, we check if any of the values is less than or equal to the previous value to return false.
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
    TreeNode prev;

    public bool IsValidBST(TreeNode root) {
        prev = null;
        return AddBST(root);
    }
    
    public bool AddBST(TreeNode root)
    {
        if(root!=null)
        {
            bool left = AddBST(root.left);

            if(prev!=null && prev.val>=root.val)
            {
                return false;
            }
            prev = root;
            bool right = AddBST(root.right);
            return left && right;
        }
        return true;
    }
}
