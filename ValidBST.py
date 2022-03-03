# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC: O(n)
# SC: O(n)

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def inOrder(root):
            
            if not root:
                return True
            
            left = inOrder(root.left)
            
            if(root.val<=self.prevVal):
                return False
            self.prevVal = root.val
            
            right = inOrder(root.right)
            
            return left and right
            
        self.prevVal = float('-inf')
        
        return inOrder(root)
