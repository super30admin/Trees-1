// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, did it in class first.

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
let prev;
var isValidBST = function(root) {
    prev = null;
    return inOrderTraversal(root);
};

const inOrderTraversal = (root) => {
    // Base Case
    if (root === null) return true;
    
    // Logic
    if(inOrderTraversal(root.left) == false) return false;
    
    if (prev !== null && root.val <= prev.val) return false;
    
    prev = root;
    return inOrderTraversal(root.right);
}
