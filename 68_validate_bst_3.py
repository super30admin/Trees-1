# Time complexity - O(n)
# Space complexity - O(h)

# Approach 3 - With helper recursive function that keeps track of min and max for every node in tree

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        self.isValid = True # flag to maintain
        self.helper(root, None, None)
        return self.isValid
    
    def helper(self, root: Optional[TreeNode], Min: int, Max: int) -> bool:
        if root == None:
            return
        
        # if we did this check after root.left, it'll still work (preorder/postorder will work anyway)
        if (Min != None and root.val <= Min) or (Max != None and root.val >= Max):
            self.isValid = False
            return
        
        self.helper(root.left, Min, root.val)
        self.helper(root.right, root.val, Max)