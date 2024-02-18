#
# @lc app=leetcode id=98 lang=python3
#
# [98] Validate Binary Search Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Time Complexity - O(n). We traverse through the entire tree in worst case scenario.
Space Complexity - O(h). It is the size of the recursion stack that is being maintained.

This code works on Leetcode.
'''
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool: 
        return self.helper(root, None, None) 
    
    def helper(self, root, minVal, maxVal)->bool:
        if root == None  : #check if root is null. if yes then return
            return True
        if minVal != None and root.val <= minVal: #check if root value is smaller than minimum possible value 
            return False
        if maxVal != None and root.val >= maxVal: #check if root value is greater than the maximum possible value
            return False
        # if self.flag:
        
        left = self.helper(root.left, minVal, root.val) # go left min remains same max changes to parent
        right = self.helper(root.right, root.val, maxVal) #go right min chages to parent and max remains same
        return (left and right) #both left and right tree need to be valid for BST to be valid.
        
        
# @lc code=end

