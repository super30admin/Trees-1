# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    '''Time Complexity - O(N) Worst case for right or left skewed tree
       Space complexity - O(N) recursive stack
       Code submitted on leetcode
       
       Algorithm:
       
       - For every node in the left, maximum value will be the root value
         and for every right node, minimum value will be root value
       
    '''
    def isValidBST(self, root: TreeNode) -> bool:
        
        if root == None:
            return False
        
        return self.helper(root,None,None)
    
    def helper(self,root,minimum,maximum):
        
        if root == None:
            return True
        
        if minimum != None and minimum>=root.val: # This will be checked for right
            return False
        
        if maximum != None and maximum<=root.val: # for left
            return False
        
        return self.helper(root.left,minimum,root.val) and self.helper(root.right,root.val,maximum) #If both true then return true else false