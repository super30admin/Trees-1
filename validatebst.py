# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(root,left,right):
            if root == None:
                return True
            if left and root.val <= left.val:
                return False
            if right and root.val >= right.val:
                return False
            return helper(root.left,left,root) and helper(root.right,root,right)
        
        return helper(root,None,None)