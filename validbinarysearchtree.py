class Solution:
    def isValidBST(self, root):

        def dfs(node, low, high):
            if not node:
                return True

            # Current node must be within the allowed range
            if not (low < node.val < high):
                return False

            # Left subtree: values must be < node.val
            # Right subtree: values must be > node.val
            return (dfs(node.left, low, node.val) and
                    dfs(node.right, node.val, high))

        return dfs(root, float("-inf"), float("inf"))

    # TC - O(n)
    # SC - O(h) where h is height of tree, O(logn) for balanced binary tree and O(n) for skewed tree.