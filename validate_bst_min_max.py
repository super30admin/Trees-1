# Time Complexity : O(h) where h is height of the tree
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.inOrder(root, None, None)
    
    def inOrder(self, root, minr, maxr):
        
        if root is None:
            return True
        if minr is not None and minr >= root.val:
            return False
        
        if maxr is not None and maxr <= root.val:
            return False
        
        left = self.inOrder(root.left, minr, root.val)
        right = self.inOrder(root.right, root.val, maxr)
            
        return left and right