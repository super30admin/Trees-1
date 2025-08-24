// Time Complexity: O(N) where N is the number of nodes in the binary tree
// Space Complexity: O(H) where H is the height of the binary tree, which is recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * We will do an inorder traversal of the binary tree and keep track of the previous node visited.
 * If we put the node values in an array during inorder traversal, they should be in ascending order for a valid BST and using this condition, we came up with the condition prev.val>=root.val to check for the violation of the BST property.
 * The flag variable is used to track the violation of the BST property and the condition to stop further traversal once a violation is found.
 */


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
class BinaryTree {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag=true;
        helper(root);
        
        return flag;
        
    }

    private  void helper(TreeNode root)
    {
        if(root==null)
            return;
        
        helper(root.left);
        if(prev!=null&&prev.val>=root.val)
        {
            flag=false;
        }
        prev=root;
        if(flag){helper(root.right);}
    }
}