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

// Approach 1 global prev
// Time Complexity : O(n)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach
// did inorder traversal and if the prev was greater than current returned false

class Solution {
    boolean isValid;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        isValid = true;
        inorder(root);
        return isValid;

    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}

// Approach 2 Iterative
// Time Complexity : O(n)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach
// did inorder traversal and if the prev was greater than current returned false
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        TreeNode prev = null;
        Stack<TreeNode> s = new Stack();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}

// Approach 3 passing array as paramter to recursive function
// Time Complexity : O(n)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach
// did inorder traversal and if the prev was greater than current returned false

class Solution {
    boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        isValid = true;
        TreeNode[] prev = new TreeNode[1];
        inorder(root, prev);
        return isValid;

    }

    public void inorder(TreeNode root, TreeNode[] prev) {
        if (root == null)
            return;
        inorder(root.left, prev);
        if (prev[0] != null && prev[0].val >= root.val) {
            isValid = false;
            return;
        }
        prev[0] = root;
        inorder(root.right, prev);
    }
}

// Approach 4 return type as boolean for recursive function
// Time Complexity : O(n)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach
// did inorder traversal and if the prev was greater than current returned false

class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        TreeNode[] prev = new TreeNode[1];
        return inorder(root, prev);
        // return isValid;

    }

    public boolean inorder(TreeNode root, TreeNode[] prev) {
        if (root == null)
            return true;
        if (inorder(root.left, prev) == false)
            return false;
        if (prev[0] != null && prev[0].val >= root.val) {

            return false;
        }
        prev[0] = root;
        return inorder(root.right, prev);
    }
}

// Approach 5

// Time Complexity : O(n)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach
// Used the max and min to compare the subtree values at each point in traversal
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        if (helper(root.left, min, root.val) == false) {
            return false;
        }
        return helper(root.right, root.val, max);
    }
}