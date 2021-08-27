# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = None

    def inorder(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        if self.inorder(root.left) == False:
            return False
        if self.prev != None and self.prev.val >= root.val:
            return False
        self.prev = root
        return self.inorder(root.right)

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        return self.inorder(root)