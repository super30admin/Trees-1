#Time complexity: O(n)
#Space complexity: O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    isValid=True
    prev=None
    def isValidBST(self, root) -> bool:
        self.prev=None
        self.prev=None
        self.inorder(root)
        return self.isValid
    def inorder(self,root):
        if root == None:
            return
        self.inorder(root.left)
        if self.prev and self.prev.val >= root.val:
            self.isValid=False
        self.prev=root
        self.inorder(root.right)