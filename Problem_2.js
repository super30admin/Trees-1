// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
let idx;
let map;

var buildNewTree = (preorder, start, end) => {
    if (start > end)
        return null;

    let rootVal = preorder[idx];
    idx++;
    let index = map.get(rootVal);
    let root = new TreeNode(rootVal);

    root.left = buildNewTree(preorder, start, index - 1);
    root.right = buildNewTree(preorder, index + 1, end);

    return root;
}
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function (preorder, inorder) {
    if (inorder === null || preorder === null || inorder.length === 0 || preorder.length === 0)
        return null;
    map = new Map();
    idx = 0;
    inorder.forEach((ele, i) => map.set(ele, i));

    return buildNewTree(preorder, 0, preorder.length - 1);
};