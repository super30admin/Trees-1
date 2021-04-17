# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    prev = TreeNode()

    def isValidBST(self, root: TreeNode) -> bool:
        if not root:
            return False
        global prev
        prev = None
        return self.inorder(root)

    def inorder(self, root) -> bool:

        if root is None:
            return True

        if not self.inorder(root.left):
            return False

        global prev
        if prev != None and prev.val >= root.val:
            return False

        prev = root

        return self.inorder(root.right)