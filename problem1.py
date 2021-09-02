#time- O(n)
#psace- O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(root ,max_v,min_v):
            if root==None:
                return True
            return root.val>min_v and root.val<max_v and helper(root.left ,root.val,min_v) and helper(root.right ,max_v,root.val)
        max_v= float('inf')
        min_v= float('-inf')
        return helper(root ,max_v,min_v)
    
