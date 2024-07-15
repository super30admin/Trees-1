# time: O(n)
# space: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.prev = float('-inf')

        def inorder(root):
            if root==None:
                return

            inorder(root.left)
            if root.val <= self.prev:
                self.flag = False
            self.prev = root.val
            inorder(root.right)


        inorder(root)
        return self.flag


        