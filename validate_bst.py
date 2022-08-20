# Time Complexity : O(n) where n is the number of nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution1:
    flag = True
    prev = None

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.validity_helper(root)
        return self.flag

    def validity_helper(self, root: Optional[TreeNode]):
        if root is None:
            return
        if self.flag:
            self.validity_helper(root.left)
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False
            return
        self.prev = root
        if self.flag:
            self.validity_helper(root.right)


class Solution2:

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        _stack = []
        prev = None
        while root is not None or len(_stack) > 0:
            while root is not None:
                _stack.append(root)
                root = root.left
            root = _stack.pop()
            if prev is not None and prev.val >= root.val:
                return False
            prev = root
            root = root.right

        return True


class Solution3:
    flag = True
    prev = None

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.validity_helper(root)
        return self.flag

    def validity_helper(self, root: Optional[TreeNode]):
        if root is None:
            return
        if self.flag:
            self.validity_helper(root.left)
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False
            return
        self.prev = root
        if self.flag:
            self.validity_helper(root.right)


class Solution4:

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.validation_helper(root, None, None)

    def validation_helper(self, root: Optional[TreeNode], _max: Optional[int], _min: Optional[int]) -> bool:
        if root is None:
            return True
        if _min is not None and root.val <= _min:
            return False
        if _max is not None and root.val >= _max:
            return False
        return self.validation_helper(root.left, root.val, _min) and self.validation_helper(root.right, _max, root.val)