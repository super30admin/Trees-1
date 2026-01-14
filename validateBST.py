# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.flag = True
        self.prev = None

    def isValidBST(self, root):
        self.helper(root)
        return self.flag

    def helper(self, root):
        if root is None:
            return

        self.helper(root.left)

        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False

        self.prev = root
        self.helper(root.right)
###################################################################
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None
        self.flag = True
        self.helper(root)
        return self.flag
    def helper(self,root):
        if root is None:
            return
        if not self.flag:
            return
        self.helper(root.left)
        if self.prev is not None and self.prev >= root.val:
            self.flag = False
        self.prev = root.val
        self.helper(root.right)


