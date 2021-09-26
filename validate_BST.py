# // Time Complexity : O(n) 
# // Space Complexity : O(h) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.min = float('-inf')
        
    def isValidBST(self, root: TreeNode) -> bool:
        if not root: return True
        left = self.isValidBST(root.left)
        if root.val > self.min:
            self.min = root.val
        else:
            return False
        right = self.isValidBST(root.right)
        return left and right
        
        