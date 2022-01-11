# Time Complexity : O(n)
# Space Complexity : O(h) where h is the height of the tree.
# Did this code successfully run on Leetcode : Yes.
# Any problem you faced while coding this : Class Solution.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(root,minLimit,maxLimit):
            if root == None:
                return True
            if maxLimit != None and root.val >= maxLimit:
                return False
            if minLimit != None and root.val <= minLimit:
                return False
            return helper(root.left,minLimit,root.val) and helper(root.right,root.val,maxLimit)
        return helper(root,None,None)
        