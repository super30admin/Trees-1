// Recursive Solution
// Time Complexity : O(n)
// Space Complexity : O(logn) : recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: explained inline in code

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        // Recursive Solution
        // Base case
        if(root == null) return true;
        // keep going to the left until a leaf node is found and return false if false is encountered
        if(!isValidBST(root.left)) {
            return false;
        }
        // check if prev is not null and the order is strictly ascending
        if(prev != null && prev.val >= root.val) {
            return false;
        }
        // assign current node value to prev for next check
        prev = root;
        // go to the right nodes recursively and return whether its true or false. All other cases have already been checked so whatever we get by traversing the right nodes, that will be the final outcome.
        return isValidBST(root.right);
        
    }
}

// Iterative solution
//Time Complexity : O(n)
//Space Complexity : O(logn)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach: explained inline in code

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        // Declaring a stack to push the nodes until a leaf node is observed
        Stack<TreeNode> stack = new Stack<>();
        // prev value for checking if elements are in sorted order or not
        TreeNode prev = null;
        // until there are elements in stack, keep iterating
        while(root != null || !stack.isEmpty()) {
            // keep going left until leaf node is found. Push all elements found on the way into stack
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // compare current element with previous element
            if(prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            // traverse right nodes of the tree
            root = root.right;
        }
        return true;
    }
}

// Recursive solution with boundaries

class Solution {
    public boolean isValidBST(TreeNode root) {
    	return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

	private boolean helper(TreeNode root, long min, long max) {
	    // base case
	    if(root == null) {
	        return true;
	    }
	    // if root value is outside any of the lower or upper bounds, return false from there itself
	    if(root.val <= min || root.val >= max) {
	        return false;
	    }
	    // on moving left of root, for a valid BST, the upper limit will always be the value at root element
	    // on moving right of root, for a valid BST, the lower limit will always be the value at root element
	    // if both the above conditions hold true then only the BST will be valid
	    return helper(root.left, min, root.val) && helper(root.right, root.val, max); 
	}
}
