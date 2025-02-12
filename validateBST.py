"""
Recursive Inorder -
TC - O(n) since traversing all nodes
SC - O(h) where h is the height of the tree
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = -math.inf

        def validateInorder(node):
            if not node: return True

            if not validateInorder(node.left): return False

            if node.val <= self.prev: return False

            self.prev = node.val

            return validateInorder(node.right)

        return validateInorder(root)
