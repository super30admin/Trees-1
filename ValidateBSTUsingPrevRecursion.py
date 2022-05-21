'''
time complexity: O(n)
space complexity: O(n) or O(h)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
    
        def helper(root):
            if root==None: return True
            if not helper(root.left):
                return False
            if(self.prev!=None and self.prev>=root.val):
                return False
            self.prev = root.val
            return helper(root.right)
        self.prev = None
        return helper(root)
        