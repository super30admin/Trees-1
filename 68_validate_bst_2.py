# Time complexity - O(n)
# Space complexity - O(h)

# Approach 2 - With stack instead of recursion

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
        Stack = []
        prev = None # initiate prev pointer
        isValid = True # flag to maintain
        while root != None or len(Stack) > 0:
            while root != None:
                Stack.append(root)
                root = root.left
            root = Stack.pop()
            if prev != None and prev.val >= root.val:
                isValid = False
                break
            prev = root
            root = root.right
        return isValid