# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def dfs(self, root):
        if not root:
            return

        self.dfs(root.left)
        if self.prev is not None and self.prev.val >= root.val:  # (checking if values are not in sorted order, if not then it is not valid  Binary Search Tree)
            self.flag = False
        self.prev = root
        self.dfs(root.right)

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.prev = None
        self.dfs(root)
        return self.flag

