'''
Time Complexity: O(n)
Space Complexity: O(h) where h is the height of the tree
Run on Leetcode: YES
'''
from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    prev = None
    flag = True
    def helper(self, root: Optional[TreeNode]) -> bool:
        #base
        if not root:
            return
        self.helper(root.left)
        if self.prev != None and self.prev >= root.val:
            self.flag = False
        self.prev = root.val
        self.helper(root.right)
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        #null
        if not root:
            return True
        self.helper(root)
        return self.flag
        