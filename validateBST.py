
"""
TC: O(N) N- number of nodes
SP: O(N) run time space on call stack, if it's a balanced tree SP O(H) where H is height of tree
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inorder(root):
            if not root:
                return True
            if not inorder(root.left):
                return False
            if root.val<= self.prev:
                return False
            self.prev = root.val
            return inorder(root.right)
        self.prev = float('-inf')
        return inorder(root)

        
        
        