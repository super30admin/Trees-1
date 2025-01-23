# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # TC : O(n) - no of nodes
        # SC : O(h) - height of tree
        def checkvalid(root,minval=float('-inf'),maxval=float('inf')):
            if root is None:
                return True
            if (minval != None and minval >= root.val) or (maxval != None and root.val >= maxval):
                return False
            return checkvalid(root.left,minval,root.val) and checkvalid(root.right,root.val,maxval)
        return checkvalid(root)