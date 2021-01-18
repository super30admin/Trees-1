# // Time Complexity : O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes



#Recursive approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev=None
    isvalid=True
    def isValidBST(self, root: TreeNode) -> bool:
        if(root==None):
            return False
        self.helper(root)
        return self.isvalid
    def helper(self, root: TreeNode):
        if(root==None):
            return
        self.helper(root.left)
        if(self.prev!=None and self.prev.val>=root.val):
            self.isvalid=False
            return
        self.prev=root
        self.helper(root.right)
        