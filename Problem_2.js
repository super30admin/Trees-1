// Time Complexity : O(n) // n is number of tree nodes
// Space Complexity : O(n) // extra space taken by slicing the inorder and preorder arrays for left and right children traversal
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */

//Below is one way of solving using extra space; Can be done using pointers too without using slice
var buildTree = function(preorder, inorder) {
    //base
    if(preorder.length === 0) return null;

    //recursive logic
    let rootVal = preorder[0];
    let rootIndex = inorder.indexOf(rootVal); // O(n) search
    let root = new TreeNode(rootVal);

    let inorderLeft = inorder.slice(0, rootIndex); // from 0 to not including the rootIndex element
    let inorderRight = inorder.slice(rootIndex+1); // from not including the rootIndex to end of the array
    let preorderLeft = preorder.slice(1, inorderLeft.length+1);
    let preorderRight = preorder.slice(inorderLeft.length+1, preorder.length);
    
    root.left = buildTree(preorderLeft, inorderLeft);
    root.right = buildTree(preorderRight, inorderRight);

    return root;
};
