# Time Complexity: O(N^2)
# Space Complexity : O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def dfs(root,mi,ma):
            if not root:
                return True
            if root.val<ma and root.val>mi and dfs(root.left,mi,root.val) and dfs(root.right,root.val,ma):
                return True
            return False
        return dfs(root,float('-inf'),float('inf'))
                
            
        return dfs(root,root)