# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        import math
        
        def bst(root,low,high):
            if root is None:
                return True
            
            if root.val>=high or root.val<=low:
                return False
            else:
                return bst(root.left,low,root.val) and bst(root.right,root.val,high)
            
        return bst(root,-math.inf,math.inf)
        