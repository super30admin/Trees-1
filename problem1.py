# Time Complexity : O(N) not sure
# Space Complexity : O(N) not sure
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def validate(self, node, minValue, maxValue):
        
        if node == None:
            return True
        
        if (minValue!= None and node.val<=minValue) or (maxValue!=None and node.val >= maxValue):
            return False
        
        return self.validate(node.left, minValue, node.val) and self.validate(node.right,node.val,maxValue)
    
        
    def isValidBST(self, root: TreeNode) -> bool:
              
        return self.validate(root, None, None)
        