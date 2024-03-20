/*
 * TC: O(N) // where N is the number of nodes, since we are traversing every node
 * SC: O(h) // where h is the height of the tree, as at max our call stack will store height number of nodes.
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

 // void based recursion
class Solution1 {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        helper(root, 0);
        return sum;
    }

    void helper(TreeNode root, int curVal) {
        if(root == null) {
            return;
        }
        curVal = curVal * 10 + root.val;
        if(root.left == null && root.right == null) 
            sum += curVal;
        helper(root.left, curVal);
        helper(root.right, curVal);
    }
}


// int based recursion

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
class Solution2 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0, 0);
    }

    int helper(TreeNode root, int curVal, int sum) {
        if(root == null) {
            return sum;
        }
        curVal = curVal * 10 + root.val;
        if(root.left == null && root.right == null) 
            return sum += curVal;
        int left = helper(root.left, curVal, sum);
        int right = helper(root.right, curVal, sum);
        return left + right;
    }
}


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
class Solution3 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    int helper(TreeNode root, int curVal) {
        if(root == null) {
            return 0;
        }
        curVal = curVal * 10 + root.val;
        if(root.left == null && root.right == null) 
            return curVal;
        int left = helper(root.left, curVal);
        int right = helper(root.right, curVal);
        return left + right;
    }
}