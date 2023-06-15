# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to validate the bst.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:

    def inorder(self, root, low, high):
        if root == None:
            return True
        
        if not (low < root.val <high):
            return False

        return self.inorder(root.left, low, root.val) and self.inorder(root.right, root.val, high)
        
    

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.inorder(root, -inf, inf)
