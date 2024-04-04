#T.C. O(n)
#S.C. O(h) where h is the height of the tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.flag = True

    def helper(self, root, min_e, max_e):
        if root is None:
            return
        if min_e != None and root.val <= min_e:
            self.flag = False
        if max_e != None and root.val >= max_e:
            self.flag = False
        self.helper(root.left, min_e, root.val)
        self.helper(root.right, root.val, max_e)

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.helper(root, None, None)
        return self.flag
