'''
Time Complexity -->
O(n)

Space Complexity -->
O(h) whee his the height of the tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        stack = []
        prev = float('-inf')
        while stack or root!=None:
            while root!=None:
                stack.append(root)
                root=root.left
        
            r = stack.pop(-1)
            if r.val>prev:
                prev = r.val
            else:
                return False
        
            root = r.right
        return True
        