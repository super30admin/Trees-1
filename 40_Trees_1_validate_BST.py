#Time Complexity : O(n) where n is the number of nodes 
#Space Complexity : O(h) where h is the height if the tree, In worst case, h could be n
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : 
#Your code here along with comments explaining your approach




# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def isValidBST(self,root):
        
        def helper(root,lower,upper): 
            if root==None: 
                return True
            return lower<root.val<upper and helper(root.left,lower,root.val) and helper(root.right,root.val,upper)
        
        return helper(root,float('-inf'),float('inf'))
            
        
    
        

    
        