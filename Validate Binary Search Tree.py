# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root) -> bool:
        self.prev = None
        self.isValid = True

        self.inorder(root)

        return self.isValid

    def inorder(self, root) -> None:
        if root is None:
            return

        self.inorder(root.left)

        if self.prev is not None and self.prev.val >= root.val:
            self.isValid = False
            return

        self.prev = root

        # print(root.val)

        self.inorder(root.right)
        