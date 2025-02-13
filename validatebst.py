# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# TC : O(n)
# sc : O(h)

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        s = []
        prev = -float('inf')
        while root or s:
            while root != None:
                s.append(root)
                root = root.left
            root = s.pop()
            if root.val <= prev:
                return False

            prev = root.val
            root = root.right
        return True