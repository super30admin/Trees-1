/* Valid BST */

/* Iterative Solution 
// Time Complexity : O(n) as we will be visiting all nodes once
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We will be following Iterative solution in which we 
//will make sure if value of left child is lesser than root value
//and right child value is greater than that of root value.

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
        //Base case
        if(root == null) return true;
        //initialise stack
        Stack<TreeNode> stack = new Stack<>();
        //initialise prev as null
        TreeNode prev = null;
        //Terminating condition: check if root is not null and stack is not empty
        while(root != null || !stack.isEmpty()){
            while(root != null){
                //keep pushing elements into stack
                stack.push(root);
                //after pushing root, iterate and push left child
                root = root.left;
            }
            //pop element
            root = stack.pop();
            if(prev != null && root.val <= prev.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
}



/* Recursive Solution 
// Time Complexity : O(n) as we will be visiting all nodes once
// Space Complexity : O(h) where h-height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We will be following recursive solution in which we 
//will make sure if value of left child is lesser than root value
//and right child value is greater than that of root value.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    
    private boolean isValid(TreeNode root, Integer min, Integer max){
        //base case
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
        
    }
}

*/

