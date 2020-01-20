from math import inf
from create_tree_node import stringToTreeNode, TreeNode
from typing import List


class Solution:

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

    def isValidBST_inorder_recursive_pass_by_reference(self, root: TreeNode) -> bool:
        """
            // Time Complexity : O(n)
                    'n' is the number of nodes
            // Space Complexity : O(h) Recursive stack space
                    'h' is the height of the tree
            // Did this code successfully run on Leetcode : Yes
        """
        prev = []
        return self._helper_recursive_reference(root, prev)

    # LDR
    def _helper_recursive_reference(self, root: TreeNode, prev: List):
        if root is None: return True
        if not self._helper_recursive_reference(root.left, prev): return False
        if prev and prev[-1] >= root.val: return False
        prev.append(root.val)
        return self._helper_recursive_reference(root.right, prev)

    def isValidBST_inorder_recursive_pass_by_value(self, root: TreeNode) -> bool:
        """
            // Time Complexity : O(n)
                    'n' is the number of nodes
            // Space Complexity : O(h) Recursive stack space
                    'h' is the height of the tree
            // Did this code successfully run on Leetcode : Yes
        """

        return self._helper_recursive_value(root)

    # LDR
    # class variable
    prev = -inf

    def _helper_recursive_value(self, root: TreeNode):
        if root is None: return True
        if not self._helper_recursive_value(root.left): return False
        if self.prev >= root.val: return False
        self.prev = root.val
        return self._helper_recursive_value(root.right)

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


if __name__ == '__main__':
    h = Solution()
    root = stringToTreeNode([5, 1, 4, 'null', 'null', 3, 6])
    print(h.isValidBST_inorder_recursive_pass_by_reference(root))
    root = stringToTreeNode([1, 1])
    print(h.isValidBST_inorder_recursive_pass_by_reference(root))
    print(h.isValidBST_inorder_recursive_pass_by_value(root))
