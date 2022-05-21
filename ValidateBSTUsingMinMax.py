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
        def helper(root,minVal,maxVal):
            if root==None: return True
            if(minVal!=None and root.val<=minVal):
                return False
            if(maxVal!=None and root.val>=maxVal):
                return False
            return helper(root.left,minVal,root.val) and helper(root.right,root.val,maxVal)

            

            
        minVal = None
        maxVal = None
        return helper(root,minVal,maxVal)
    
    