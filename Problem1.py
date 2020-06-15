"""

    Student : Shahreen Shahjahan Psyche
    Time Complexity : O(N)
    Space Complexity : O(N)

    This code passed all the test cases of Leetcode

"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    
    def _checkValid(self, root, upper, lower):
        
        # if we reach NULL
        if root is None:
            return True
        
        valid = True
        
        # checking BST property
        if root.val <= lower or root.val >= upper:
            return False
        
        # left tree
        left = self._checkValid(root.left, root.val, lower)
        # right tree
        right = self._checkValid(root.right, upper, root.val)
          
        valid = valid and right and left
        return valid
        

    def isValidBST(self, root: TreeNode) -> bool:
        valid = self._checkValid(root, float('inf'), float('-inf'))
        return valid
        
        