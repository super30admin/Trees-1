# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity = O(n)
# Space Complexity = O(H)
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.isValid = True
        def DST(root):
            if not root:
                return True
            if root.left is not None:
                DST(root.left)
            if(root.val <= self.prev):
                self.isValid= False
            self.prev = root.val
            if root.right is not None:
                DST(root.right)
        self.prev = -math.inf
        DST(root)
        return self.isValid
        