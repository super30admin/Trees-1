# // Time Complexity : O(n)
# // Space Complexity : O(h) - height of the tree
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
	# Consider a node and set the limits for the selected node which will be between
	# -inf to previous node or previous node to inf
	
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def checkValid(self,Node,Min,Max):
        if Node == None:
            return True
        
        if Node.val <= Min or Node.val >= Max:
            return False
        
        return self.checkValid(Node.left,Min,Node.val) and self.checkValid(Node.right,Node.val,Max)
    
    def isValidBST(self, root: TreeNode) -> bool:
        MinVal = float('-inf')
        MaxVal = float('inf')
        return self.checkValid(root,MinVal,MaxVal)