// Time Complexity : O(n)
// Space Complexity : O(h) Stack will contain at most depth of the tree at any point in time
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with c`omments explaining your approach

/* KEY PROPERTY OF BST IS INORDER TRAVERSAL GIVES ASCENDING ORDER
 * Recurrsion: Any recurrsion call works like: push baby and move to parent, we keep a teack of boolean and prev variable globally,
 * and call inorder on left child then check the value with prev value if not greater we set boolean variable to false. 
 * Set prev and move to right. 
 */

import java.util.Stack;

/**
 * Definition for a binary tree node.
 */

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

class Solution {

    TreeNode prev;
    boolean isValid;
    public boolean isValidBSTRec(TreeNode root) {
        if(root == null) {
            return true;
        }
        isValid = true;
        inorder(root);
        return isValid;
    }

    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h) Stack will contain at most depth of the tree at any point in time
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with c`omments explaining your approach
/*
 * Iterative approach where we explicitly maintain a stack and keep on pushing left elements untill root is null
 * Then we pop and check if value is greater than previous value and set previous and move to right side. 
 */
class SolutionItr {

    public boolean isValidBSTItr(TreeNode root) {
        if(root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h) Stack will contain at most depth of the tree at any point in time
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with c`omments explaining your approach
/*
 * KEY PROPERTY OF BST IS INORDER TRAVERSAL GIVES ASCENDING ORDER
 * Recurrsion: Any recurrsion call works like: push baby and move to parent, we keep a teack of prev variable globally,
 * and call inorder on left child then check the value with prev value if not greater we return false. 
 * Set prev and move to right. 
 */
class ValidBSTRecurrsion {

    TreeNode prev; 
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean case1 = inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        boolean case2 = inorder(root.right);
        return case1 && case2;
    } 
}


// Time Complexity : O(n)
// Space Complexity : O(h) Stack will contain at most depth of the tree at any point in time
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with c`omments explaining your approach
/*
 * KEY PROPERTY OF BST IS INORDER TRAVERSAL GIVES ASCENDING ORDER
 * This is traversal independent solution where we use min and max values for each node and check if it lies within the bounds.
 * We start from null and not Integer.MAX_VALUE and Integer.MIN_VALUE as question has a constrain that those are allowed root values.
 * If root.val <= min || root.val >= max return false.
 */
class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return false;
        }
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }
        boolean case1 = helper(root.left, min, root.val);
        if((min != null && root.val <= min) || ( max != null && root.val >= max)) {
            return false;
        }
        boolean case2 = helper(root.right, root.val, max);
        return case1 && case2;
    }
}
