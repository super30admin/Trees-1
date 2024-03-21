# TC = O(n)
# TC = O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def __init__(self):
        self.prev = None
        self.flag = True

    def inOrderTraversal(self, root):

        if root == None:
            return
        self.inOrderTraversal(root.left)

        if self.prev != None and root.val <= self.prev.val:
            self.flag = False

        self.prev = root
        self.inOrderTraversal(root.right)

    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        self.inOrderTraversal(root)
        return self.flag
