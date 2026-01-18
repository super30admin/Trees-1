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
Intuition:
We recursively validate the tree by ensuring each node’s value lies within an allowed range defined by its ancestors.

When moving left, we update the maximum bound to the current node’s value; when moving right, we update the minimum bound.

If any node violates it's range, the tree is not a valid BST. Otherwise, all nodes satisfy the BST property.

T.C: O(n), S.C: O(n)


 */
var isValidBST = function (root) {

    const helper = (root, min, max) => {
        // base case
        if (!root) return true;
        // action
        if (root.val >= max || root.val <= min) {
            return false;
        }
        // left sub tree call
        const left = helper(root.left, min, root.val);
        // right sub tree call
        const right = helper(root.right, root.val, max);
        // both trees need to be valid to conside whole tree as valid bst
        return left && right;
    };

    return helper(root, -Infinity, Infinity);

};