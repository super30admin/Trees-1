// Time Complexity : O(n) - where n is the number of nodes in the BST
// Space Complexity : O(1) - O(h) - where h is the height of the BST (Recursive stack space)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach -:

Took the max and min range possible for each node in the BST, while doing depth first
recursive calls, checking whether node val falls with in the range or not.

Fact - > Left node will have minimum same as root and max will root value
         Right node will have minimum will be root val and max will be same as root

 */


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root) {

        if (root == null) return true;

        boolean left = helper(root.left);

        if (prev != null && prev.val >= root.val) {
            return false;
        }

        prev = root;

        return left && helper(root.right);
    }
}

public class ValidateBST {
}
