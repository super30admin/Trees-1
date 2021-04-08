# Time Complexity: O(n)
# Space Complexity: O(h) where h is the height of tree
# Ran on Leetcode: Yes


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if not root:
            return True
        stack = []
        prev = None
        while root or len(stack):
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev and prev.val >= root.val:
                return False
            prev = root
            root = root.right
        return True
        
        