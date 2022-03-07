# // Time Complexity : O(n^2)
# // Space Complexity : O(n^2)
# time and space complexity are both O(n^2) because of the inorder.index() function and 
# passing subarrays of preorder/inorder in each stack of the recursion.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder, inorder):
        
        # base case
        if not preorder or not inorder:
            return None
        
        root = TreeNode(preorder[0]) # root always starts in preorder
        mid = inorder.index(preorder[0]) # get the index of root
        
        # recursively build trees
        # passing subarrays
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid]) 
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
        
        return root
