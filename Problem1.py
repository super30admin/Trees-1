
# Time Complexity = O(n)  | Space Complexity = O(h)  h is height of the tree or log(n) if it's Balanced BST

# Definition for a binary tree node.
from typing import Optional
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None
        self.flag = True
        self.helper(root)
        return self.flag

    def helper(self, root: Optional[TreeNode]):
        # base case
        if root is None or self.flag is False: return

        self.helper(root.left)
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False
        self.prev = root
        self.helper(root.right)

