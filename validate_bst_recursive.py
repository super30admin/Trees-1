# Time Complexity : O(h) where h is height of the tree
# Space Complexity : O(h) where h is height of the tree
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
        rstack = []
        prev = None
        while root != None or len(rstack) != 0:
            
            while root != None:
                rstack.append(root)
                root = root.left
            
            root = rstack.pop()
            
            if prev is not None and root.val <= prev.val:
                return False
            
            prev = root
            
            root = root.right
            
        return True
            
        