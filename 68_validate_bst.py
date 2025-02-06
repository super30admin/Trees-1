# Time complexity - O(n) # n = num of nodes
# Space complexity - O(h) # h = height of the tree
# Why SC? -> Becoz recursion maintains a stack which stores the elements that needs to be popped out

# Approach - Maintain two pointers (prev and curr) to check if prev >= curr at any point, while traversing
# inorder on the tree

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
        self.prev = None # initiate prev pointer
        self.isValid = True # flag to maintain
        self.inorder(root)
        return self.isValid
    
    def inorder(self, root: Optional[TreeNode]) -> None:
        # base case
        if root == None:
            return
        
        self.inorder(root.left)

        if self.prev != None and self.prev.val >= root.val: # root is curr pointer
            # putting a check here becoz this is where root.val gets printed
            self.isValid = False
            return
        self.prev = root # and root will become the next val
        
        self.inorder(root.right)