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

    def inOrderTraversal(self, root) -> bool:

        if root == None:
            return True
        left = self.inOrderTraversal(root.left)

        if self.prev != None and root.val <= self.prev.val:
            return False

        self.prev = root
        right = self.inOrderTraversal(root.right)
        return left and right

    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        return self.inOrderTraversal(root) if root else False
