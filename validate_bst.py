'''
Time Complexity: O(number of nodes)
Space Complexity: O(max_depth)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if root is None:
            return True
        prev = TreeNode()
        prev = None
        
        stack = []
        while len(stack) != 0 or root is not None:
            while root is not None:
                stack.append(root)
                root = root.left
            current = TreeNode()
            current = stack.pop()
            
            # process current
            if prev is not None and prev.val >= current.val:
                return False
            prev = current
            root = current.right
        return True