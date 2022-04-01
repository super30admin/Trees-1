// Time Complexity : O(n) n is number of nodes
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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

    //inorder traversal should be in sorted order
    //we take a prev node and keep assigning it current root when we move to a new root
    //if prev < root, then ascending order, BST is valid

    //iterative version of inorder traversal
    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack();

        TreeNode prev = null;

        while(root != null || !stack.isEmpty())
        {
            //left recursive call
            while(root != null)
            {
                stack.push(root);
                root = root.left;
            }

            //under the hood operation in recursion
            root = stack.pop();

            //BST not valid
            if(prev != null && root.val <= prev.val)
                return false;

            //assign current root to prev
            prev = root;

            //right recursive call
            root = root.right;
        }

        //false has not been returned till now
        return true;

    }

}
