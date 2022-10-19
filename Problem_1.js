// https://leetcode.com/problems/validate-binary-search-tree/

// Time Complexity : O(n) n is the tree nodes
// Space Complexity : O(h) h is the tree height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : When returning true/false in recursion


// Your code here along with comments explaining your approach
// dfsRange
// Maintain a range of numbers between which the root's value shold lie

// dfsRecursive
// Inorder traversal of a BST will give numbers in increasing order.
// We keep a track of the previous number and if it is more or equal to current, the BST is invalid

var dfsRange = (root, low, high) => {
    // Base
    if (root === null)
        return true;
    // Logic
    if (low !== null && root.val <= low) return false;
    if (high !== null && root.val >= high) return false;

    return dfs(root.left, low, root.val) && dfs(root.right, root.val, high);
}

// let prev;
// let isValid;
// var recursiveDfs = (root) => {
//     if (root === null)
//         return true;

//     if (!dfs(root.left))
//         return false;
//     if (prev != null && prev >= root.val) {
//         isValid = false;
//     }
//     prev = root.val;
//     return dfs(root.right);
// }

/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function (root) {
    if (root === null) {
        return true;
    }
    // Range
    return dfsRange(root, null, null);
    // Resursive
    // prev = null;
    // isValid = true
    // recursiveDfs(root);
    // return isValid;
};