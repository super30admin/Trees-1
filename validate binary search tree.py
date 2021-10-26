# TC-O(n)
# SC-O(1)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.validate(root,None,None)
    def validate(self,node, low, high):
        if node==None:
            return True
        if (low!=None and node.val<=low) or (high!=None and node.val>=high):
            return False
        return self.validate(node.left,low,node.val) and self.validate(node.right,node.val,high)