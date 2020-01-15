from math import inf


class Solution:
    # Definition for a binary tree node.
    class TreeNode:
        def __init__(self, x):
            self.val = x
            self.left = None
            self.right = None

    def isValidBST(self, root: TreeNode) -> bool:
        """
            // Time Complexity : O(n)
                    'n' is the number of nodes
            // Space Complexity : O(h)
                    'h' is the height of the tree
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english:
                - Do an inorder traversal
                - If the last element in the stack is greater than the current element
                  not a valid BST
        """
        # in order traversal LDR
        stack = []
        prev = -inf
        while root or stack:
            # if we have a left child
            if root:
                stack.append(root)
                root = root.left
            else:
                # pop data
                cur = stack.pop()
                if prev >= cur.val:
                    return False
                prev = cur.val
                root = cur.right
        return True

    prev = -inf

    def isValidBST_inorder_recursive(self, root: TreeNode) -> bool:
        """
            // Time Complexity : O(n)
                    'n' is the number of nodes
            // Space Complexity : O(h) Recursive stack space
                    'h' is the height of the tree
            // Did this code successfully run on Leetcode : Yes
        """
        return self._helper_recursive(root)

    # LDR
    def _helper_recursive(self, root: TreeNode):
        if root is None: return True
        if not self._helper_recursive(root.left): return False
        if self.prev >= root.val: return False
        self.prev = root.val
        return self._helper_recursive(root.right)

    def isValidBST_recursive(self, root: TreeNode) -> bool:
        """
            // Time Complexity : O(n)
                    'n' is the number of nodes
            // Space Complexity : O(h) Recursive stack space
                    'h' is the height of the tree
            // Did this code successfully run on Leetcode : Yes
        """
        # root can have range of values from -inf to inf
        return self._helper(root, -inf, inf)

    def _helper(self, root: TreeNode, min: int, max: int):
        # base
        # we have reached the children so it is a valid sub tree
        if root is None: return True
        # if the root value is greater than maximum allowed
        # if the root value is lesser than minimum allowed
        if root.val >= max or root.val <= min: return False
        # logic
        return self._helper(root.left, min, root.val) and self._helper(root.right, root.val, max)
