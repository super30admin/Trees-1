/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

// Time complexity - O(n), n = number of ndes
// Space complexity - O(h), h= height of the tree
function isValidBST(root: TreeNode | null): boolean {
	const result = helper(root, null, null);
	return result;
}

function helper(node: TreeNode, min?: number, max?: number) {
	if (!node) return true;

	// check if the current node's value violates the min or max constraints
	if (min !== null && node.val <= min) return false;
	if (max !== null && node.val >= max) return false;

	return (
		helper(node.left, min, node.val) && helper(node.right, node.val, max)
	);
}
