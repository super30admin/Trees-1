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
    // Approach 1 
    // Time Complexity:
    // O(n) - n is the number of nodes

    // Space Complexity:
    // O(h) - h is the height of the tree.

// We do an in-order traversal to check values in increasing order.

// If we ever find a current value smaller than or equal to the previous, we flip a flag.

// The flag acts as conditional recursion and skips extra calls once invalid BST is detected.

    bool flag = true;
    TreeNode prev;
    public bool IsValidBST(TreeNode root) {
        helper(root);
        if(!flag)
            return false;
        return true;
    }
    public void helper(TreeNode root)
    {
        if(root == null)
        return ;
       
        if(flag)
            helper(root.left);
        if(prev != null && prev.val >= root.val)
        {
            flag = false;
        }
         prev = root;
        if(flag)
            helper(root.right);
    }
}