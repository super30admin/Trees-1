# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        # keeping track of prev and root nodes
        self.prev = None
        self.flag = True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.helper(root)
        return self.flag

    def helper(self, root):
        if root == None:
            return
        self.helper(root.left)
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False
        # making root as new previous node
        self.prev = root

        self.helper(root.right)


# time complexity is O(n)
# space complexity is O(n)
