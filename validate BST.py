# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = None
        self.flag = True
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.helper(root)
        return self.flag

    def helper(self,root):
        if root is None:
            return
        self.helper(root.left)
        if (self.prev is not None and root.val<=self.prev.val): # catching a breach in BST
            self.flag = False
            return # Don't travel all the nodes
        self.prev = root
        self.helper(root.right)

    
        