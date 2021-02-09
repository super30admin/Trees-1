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

// Time Complexity : O(N)
// Space Complexity : O(max(depth))
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :
Inorder traversal of BST gives ascending order of values. Validate ascending order.

// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;

        TreeNode prev = null;
        Deque<TreeNode> stack = new LinkedList<>();

        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }

            TreeNode current = stack.poll();

            if(prev!=null && prev.val>=current.val) return false;

            prev = current;

            root = current.right;
        }

        return true;
    }
}