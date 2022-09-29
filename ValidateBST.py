"""
https://leetcode.com/problems/validate-binary-search-tree/
Notes --
Inorder - LRootR
even if do RiRootL, that would work too, but we'd get descending order

Approach --
a. Using recursion
TC - O(n) - since each element is touched twice but printed once
SC - O(h) -- where h is height of tree. internal stack is used which is accounted for.

b. Using inorder

TC - O(n)
SC - O(n)
"""
import math

root = [2, 1, 3]


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.prev = -math.inf
        print(self.prev)

    def validateBST(self, root: TreeNode) -> bool:
        self.prev = -math.inf

        def inorder(root):
            if not root:
                return True
            if not inorder(root.left):
                return False
            if root.val <= self.prev:
                return False
            self.prev = root.val
            return inorder(root.right)

        return inorder(root)


print(Solution.validateBST(root))
