# problem 1 - https://leetcode.com/problems/validate-binary-search-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def __init__(self):
        self.flag = True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.helper(root,float(-inf),float(inf))
        return self.flag
    
    def helper(self,node,min_val,max_val):
        if not node:
            return
        if node.val >= max_val or node.val <= min_val:
            self.flag = False 
        self.helper(node.left,min_val,node.val)
        self.helper(node.right,node.val,max_val)
        
        