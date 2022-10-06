# Time complexity: O(n)
# Space complexity: O(n)

# The code successfully ran on Leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = None
        self.isValid = True
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        self.inorder(root)
        
        return self.isValid
    
    def inorder(self, root) -> None:
        # Base
        if root == None: return
        
        # Logic
        self.inorder(root.left)
        
        if self.prev != None and self.prev.val >= root.val:
            self.isValid = False
            return
        
        self.prev = root
        
        self.inorder(root.right)        
        