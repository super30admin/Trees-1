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
    // Time Complexity : O(n), where n is no of nodes in the BST
    // Space Complexity : O(log(n)), log n = height of the tree
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    //Recursive Approach - Made use of the fact that inorder traversal of the BST gives the node values in ascending order.
    //Kept a prev node and checked for each inorder trav, that its value is smaller than the current node value.
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        if(prev != null && root.val <= prev.val) return false;
        prev = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}

class Solution {
    // Time Complexity : O(n), where n is no of nodes in the BST
    // Space Complexity : O(log(n)), log n = height of the tree
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    //Iterative Approach
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;

        while(curr != null || !st.isEmpty()) {
            while(curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            if(prev != null && prev.val >= curr.val) {
                return false;
            }
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
}