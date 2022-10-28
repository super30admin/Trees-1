#Time Complexity - O(n)
#Space Complexity - O(h) where h is height of binary tree
#Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, float('-inf'), float('inf'))
    
    def helper(self,root, left, right):
        #base
        if root is None:
            return True
        
        #recursion
        return root.val > left and root.val < right and self.helper(root.left, left, root.val) and self.helper(root.right, root.val, right)