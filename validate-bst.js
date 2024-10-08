/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
    if(root === null) return true;

    return validate(root, -Infinity, Infinity);
};

let validate = function(node, lower, upper) {
    if(node === null) {
        return true;
    }

    if(node.val < upper && node.val > lower) {
        return validate(node.left, lower, node.val) && validate(node.right, node.val, upper);
    } 
    else {
        return false;
    }
}