# TC: O(n)
# SC: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inorder(root):
            if not root:
                return
            inorder(root.left)
            if root.val <= self.prev:
                self.flag = False
            self.prev = root.val
            return inorder(root.right)

        self.prev = float('-inf')
        self.flag = True
        inorder(root)
        return self.flag