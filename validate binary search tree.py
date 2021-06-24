# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def __init__(self):
        self.prev = None

    def inOrderTraversal(self, root):
        if root == None: return True

        if self.inOrderTraversal(root.left) is False: return False
        if self.prev != None and self.prev.val >= root.val: return False
        self.prev = root
        return self.inOrderTraversal(root.right)

    def isValidBST(self, root: TreeNode) -> bool:
        return self.inOrderTraversal(root)

