# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # inorder traversal: Left, root, right
        # if valid BST, then it is sorted

        def inorder(node, maxVal, minVal):
            if not node:
                return True
            return  (node.val > minVal and node.val < maxVal) and inorder(node.left, node.val, minVal) and inorder(node.right, maxVal, node.val)

        return inorder(root, float('inf'), float('-inf'))
        
# TC: O(n)
# SC: O(h)