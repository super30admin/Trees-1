// 98. Validate Binary Search Tree
//https://leetcode.com/problems/validate-binary-search-tree/description/

/**
 * Time Complexity: O(n) since we traverse all nodes
 * Space Complexity: O(h) Height of the tree since call stack would have maximum function calls when we reach the leaf node
 */


// Void based conditional recursion

class Solution {

    TreeNode prev = null;
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        helper(root);

        return flag;
    }

    private void helper(TreeNode root){
        // base condition
        if(root == null || flag == false){
            return;
        }

        // logic

        helper(root.left);

        if(prev != null && root.val <= prev.val){ // if curr node i.e root is <= prev
            flag = false;
        }

        prev = root; // since current node i.e root is already processed, move to next node by updating prev to current node

        helper(root.right);
    }
}

// boolean based conditional recursion. 

class Solution {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max){

        // base condition
        if(root == null){
            return true;
        }

        // logic
        if(min != null && root.val <= min || max != null && root.val >= max){ // if not in range, not a valid BST
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max); // if left call returns false we dont give right call
    }
}