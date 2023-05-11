// Time Complexity : O(n)
// Space Complexity : O(h) since it uses a stack which may contain at most h 
//    nodes, where h is the height of the tree
// Did this code successfully run on Leetcode : Yes

/*

Approach:
Instead of the traditional recursive approach, we use an iterative approach 
where we use a stack to push the central nodes until we reach the leaf of the 
leftmost tree, then "process it" by comparing it to the previous node's value 
which we keep track of. If it's not strictly greater than the previous node's 
value, then we return false since it's not a valid BST. Then we move to the 
right part of the tree.

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

import java.util.Stack;

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        Stack<TreeNode> s = new Stack<>();
        TreeNode prev = null;
        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }

        return true;
    }
}