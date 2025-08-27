// Time Complexity : O(n)
// Space Complexity : O(h), where h is the height of the tree (stack space for recursion)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Approach : 
// Perform an inorder traversal. 
// Inorder traversal of a BST must produce strictly increasing values. 
// Keep track of previous node visited. If current <= previous, it's invalid.

public class ValidateBST {
    TreeNode prev = null; // keeps track of last visited node in inorder

    public boolean validBST(TreeNode root) {
        return helper(root);
    }

    public boolean helper(TreeNode root) {
        if (root == null) return true; // base case

        // left subtree
        if (!helper(root.left)) return false;

        // check current node against previous node
        if (prev != null && root.val <= prev.val) return false;
        prev = root; // update prev

        // right subtree
        return helper(root.right);
    }
}


// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Approach : 
// Similar inorder traversal, but instead of returning booleans, 
// it uses a global flag to track validity. 
// If violation is found, stop recursion.

class ValidateBST2 {
    TreeNode prev;
    boolean flag;

    public boolean validBST(TreeNode root) {
        this.flag = true; // assume valid initially
        helper(root);
        return flag;
    }

    public void helper(TreeNode root) {
        if (root == null) return;

        if (flag) helper(root.left); // only recurse if still valid

        // violation check
        if (prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root; // update prev

        if (flag) helper(root.right); // only recurse if still valid
    }
}


// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Approach : 
// Same inorder traversal logic. 
// Instead of global "prev", it passes "prev" as a mutable reference 
// inside an array, so recursion can update it across calls.

class ValidateBST3 {
    boolean flag;

    public boolean validBST(TreeNode root) {
        this.flag = true;
        TreeNode[] prev = new TreeNode[1]; // array used to simulate reference
        helper(root, prev);
        return flag;
    }

    public void helper(TreeNode root, TreeNode[] prev) {
        if (root == null) return;

        helper(root.left, prev);

        // check current node vs prev
        if (prev[0] != null && prev[0].val >= root.val) {
            flag = false;
        }
        prev[0] = root; // update prev

        helper(root.right, prev);
    }
}


// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Approach : 
// Use recursion with range limits (min, max). 
// For each node: 
// - it must be > min and < max
// - left subtree gets updated max = root.val
// - right subtree gets updated min = root.val
// Uses a global flag to mark invalidity.

class ValidateBST4 {
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root, null, null);
        return flag;
    }

    private void helper(TreeNode root, Integer min, Integer max) {
        if (root == null) return;

        // check constraints
        if (min != null && root.val <= min) {
            flag = false;
        }
        if (max != null && root.val >= max) {
            flag = false;
        }

        // recurse left with updated max
        helper(root.left, min, root.val);

        // recurse right with updated min
        helper(root.right, root.val, max);
    }
}


// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Approach : 
// Same min/max bounds approach as ValidateBST4. 
// But instead of global flag, recursion itself returns true/false. 
// Cleaner, avoids side effects, short-circuits early.

class ValidateBST5 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        // check constraints
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        // check left subtree (with updated max)
        if (!helper(root.left, min, root.val)) return false;

        // check right subtree (with updated min)
        return helper(root.right, root.val, max);
    }
}


// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
