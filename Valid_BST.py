# Time Complexity: O(N)
# Space Complexity: O(1)
# Approach to solve this problem given below:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def dfs(lower,upper, node):                              # Declare the dfs function 
            if not node:                                         # If no node
                return True
            elif node.val <= lower or node.val >= upper:         # if value is lower or greater than node value return false
                return False
            else:
                return dfs(lower,node.val,node.left) and dfs(node.val,upper,node.right)
            
        return dfs(float('-inf'),float('inf'),root)
        