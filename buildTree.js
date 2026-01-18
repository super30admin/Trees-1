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

Intuition:
In the below solution the preorder traversal gives the root first, so we use it to pick the current root in sequence.

Using the inorder array, we find the root’s index to determine the left and right subtree boundaries.

We recursively build the left subtree first, then the right subtree, advancing the preorder index each time.

T.C: O(N), S.C: O(N)
 */
var buildTree = function (preorder, inorder) {
    let inOrderMap = new Map();
    let idx = 0;
    for (let i = 0; i < inorder.length; i++) {
        inOrderMap.set(inorder[i], i);
    }
    const helper = (preorder, inOrderMap, start, end) => {
        // base case
        if (start > end) return null;

        // action
        const currRoot = preorder[idx];
        const rootIdx = inOrderMap.get(currRoot);
        let root = new TreeNode(currRoot);
        idx++;
        // left 
        root.left = helper(preorder, inOrderMap, start, rootIdx - 1);
        // right
        root.right = helper(preorder, inOrderMap, rootIdx + 1, end);
        return root;

    }
    return helper(preorder, inOrderMap, 0, inorder.length - 1);
};