// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, did this in class.

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */

let index;
let map = {};
var buildTree = function(preorder, inorder) {
    if (preorder == null || preorder.length == 0) return null;
    index = 0;
    for (let i = 0; i < inorder.length; i++) {
        map[inorder[i]] = i;
    }
    
    return helper(preorder, inorder, 0, inorder.length - 1);
}

var helper = function (preorder, inorder, start, end) {
    // Base Case
    if (start > end) return null;
    
    // Logic
    let root = new TreeNode(preorder[index++]);
    
    // root index in my inorder
    let inIdx = map[root.val];
    root.left = helper(preorder, inorder, start, inIdx - 1);
    root.right = helper(preorder, inorder, inIdx + 1, end);
    
    return root;
}
