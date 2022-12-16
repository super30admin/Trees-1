
// Time Complexity : O(H), H is the height of the tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
/*
 * we create a boolean flag setting it to true intiially.
 * A global prev variable to keep track of the previous node value while going to the next node in the tree.
 * We call the helper function passing the root to it. We are doing Inorder traversal to check if the tree is valid BT.
 * If the prev node is greater than next node then we change the flag value. If flag is false, it will stop the further excution and return result
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    boolean flag;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root);
        return flag;
    }

    private void helper(TreeNode root) {
        // base case
        if (root == null)
            return;

        // left
        if (flag) {
            helper(root.left);
        }

        // System.out.println(root.val);
        if (prev != null && prev.val >= root.val) {
            flag = false;
            return;
        }

        prev = root;
        if (flag) {
            helper(root.right);
        }

    }
}