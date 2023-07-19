# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Time Complexity:O(n)
    # Space Complexity:O(h)
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None
        self.flag = True
        self.inOrder(root)
        return self.flag

    def inOrder(self, root):
        if root is None:
            return
        self.inOrder(root.left)
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False
            return
        self.prev = root
        self.inOrder(root.right)
