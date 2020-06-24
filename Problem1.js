// Validate Binary Search Tree (LC 98)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Go down left and push to stack then pop from stack then check if current root is less than previous value then it is false

// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
    let stack = [];
    let inorder = -Infinity;
    
    while(!stack.length <= 0 || root != null){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        
        if(root.val <= inorder){
            return false;
        }
        inorder = root.val;
        root = root.right;
    }
    return true;
};