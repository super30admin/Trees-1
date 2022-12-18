# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBST(self, min, root, max):
        if root is None:
            return True
        if (min != None and root.val <= min):
            return False
        if (max != None and root.val >= max):
            return False

        case1 = self.isBST(min, root.left, root.val)
        case2 = self.isBST(root.val, root.right, max)

        return case1 and case2

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True

        return self.isBST(None, root, None)
