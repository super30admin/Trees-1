  
# Time Complexity : O(n) (We have to pass throught every element of tree.)
# Space Complexity : O(1) (We are not storing any additional information )
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Make helper function and pass min and max value along with it.
# - Helper function compares root value with max and min and calls helper function again on left and right child.
# - Each time helper function is called boundry is shrinked by 1 from root.

# Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
#        Calling valid function on root with min value - INF and max value + INF.
         return self.valid(root, float("-inf"), float("+inf"))
        
    def valid(self, root, minv, maxv):
#       we check if root is None to verify end of tree. If we reached end, return True because Binary tree is validated till the end of the  branch.
        if root is None:
            return True
        
#       Check main condition of binary tree
        if root.val < minv or root.val > maxv:
            return False
        
#       Check this validation on left side tree and right side tree. Put end between results because if one side returns false tree is not binary tree.
        return self.valid(root.left, minv, root.val - 1) and self.valid(root.right, root.val+1, maxv)
        
