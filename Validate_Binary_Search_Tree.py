# Time Complexity : O(N) since we visit each node exactly once
# Space Complexity : O(N) since we keep up to the entire tree.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        # Use range to check the root.val  
        return self.helper(root, float('-inf'), float('inf'))
    
    
    def helper(self, node, Min, Max):
        #Base Case
        if not node:
            return True
        
        #Check for condition of BST if it fails then return False
        if node.val <= Min or node.val >= Max:
            return False
         
         #Recursive call
        return self.helper(node.left, Min, node.val) and self.helper(node.right, node.val, Max)
