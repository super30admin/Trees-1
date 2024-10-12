# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = float('-inf')

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.inorder(root)
        
    def inorder(self, root):
        # base case
        if not root:
            return True

        # logic
        left = self.inorder(root.left)
        
        if self.prev >= root.val:
            return False

        self.prev = root.val

        right = self.inorder(root.right)
        
        return left and right